package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index == -1) {
            log("Невозможно обновить резюме \"" + resume.getUuid() + "\": Резюме не найдено в хранилище.");
            return;
        }
        storage[index] = resume;
    }

    public void save(Resume resume) {
        if (storage.length <= size) {
            log("Невозможно добавить резюме \"" + resume.getUuid() + "\": Хранилище полностью заполнено.");
            return;
        }
        int resumeIndex = findIndex(resume.getUuid());
        if (resumeIndex != -1) {
            log("Невозможно добавить резюме \"" + resume.getUuid() + "\": Резюме уже в хранилище.");
            return;
        }
        storage[size++] = resume;
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            log("Невозможно получить резюме \"" + uuid + "\": Резюме не найдено в хранилище.");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            log("Невозможно удалить резюме \"" + uuid + "\": Резюме не найдено в хранилище.");
            return;
        }
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[--size] = null;

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    private void log(String message) {
        System.out.println(message);
    }
}

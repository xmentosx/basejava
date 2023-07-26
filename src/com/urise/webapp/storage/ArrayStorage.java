package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            log("Невозможно обновить резюме \"" + resume.getUuid() + "\": Резюме не найдено в хранилище.");
            return;
        }
        storage[index] = resume;
    }

    public void save(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            log("Невозможно добавить резюме \"" + resume.getUuid() + "\": Хранилище полностью заполнено.");
            return;
        }
        int resumeIndex = getIndex(resume.getUuid());
        if (resumeIndex != -1) {
            log("Невозможно добавить резюме \"" + resume.getUuid() + "\": Резюме уже в хранилище.");
            return;
        }
        storage[size++] = resume;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
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

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}

package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            log("Невозможно получить резюме \"" + uuid + "\": Резюме не найдено в хранилище.");
            return null;
        }
        return storage[index];
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            log("Невозможно обновить резюме \"" + resume.getUuid() + "\": Резюме не найдено в хранилище.");
            return;
        }
        storage[index] = resume;
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
    public void save(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            log("Невозможно добавить резюме \"" + resume.getUuid() + "\": Хранилище полностью заполнено.");
            return;
        }
        int resumeIndex = getIndex(resume.getUuid());
        if (resumeIndex >= 0) {
            log("Невозможно добавить резюме \"" + resume.getUuid() + "\": Резюме уже в хранилище.");
            return;
        }
        saveAfterCheck(resume);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveAfterCheck(Resume resume);

    protected void log(String message) {
        System.out.println(message);
    }
}
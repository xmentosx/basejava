package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

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

    protected abstract int getIndex(String uuid);

    protected void log(String message) {
        System.out.println(message);
    }
}
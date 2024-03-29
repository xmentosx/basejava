package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(Resume resume, Integer searchKey) {
        checkStorageOverflow(resume);
        storage[size++] = resume;
    }

    @Override
    protected void doDelete(Integer searchKey) {
        storage[searchKey] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}

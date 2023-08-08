package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public final int size() {
        return size;
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage[index] = resume;
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        removeFromStorage(uuid, index);
    }

    public final void save(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        int receivedIndex = getIndex(resume.getUuid());
        if (receivedIndex >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveToStorage(resume, receivedIndex);
    }

    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveToStorage(Resume resume, int receivedIndex);

    protected abstract void removeFromStorage(String uuid, int index);

}
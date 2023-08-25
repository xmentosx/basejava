package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage  {

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        removeFromStorage(uuid, index);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
        }
        return getOnIndex(index);
    }

    public void save(Resume resume) {
        checkStorageOverflow(resume);
        int receivedIndex = getIndex(resume.getUuid());
        if (receivedIndex >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveToStorage(resume, receivedIndex);
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        saveToIndex(resume, index);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveToStorage(Resume resume, int receivedIndex);

    protected abstract void removeFromStorage(String uuid, int index);

    protected abstract Resume getOnIndex(int index);

    protected abstract void saveToIndex(Resume resume, int index);

    protected abstract void checkStorageOverflow(Resume resume);

}

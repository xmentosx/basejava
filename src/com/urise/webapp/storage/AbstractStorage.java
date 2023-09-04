package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    private final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    public void delete(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        doDelete(uuid, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        return doGet(searchKey);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistingSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void update(Resume resume) {
        Object searchKey = getExistingSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public final List<Resume> getAllSorted() {
        Resume[] resumes = getAll();
        Arrays.sort(resumes, RESUME_COMPARATOR);
        return Arrays.asList(resumes);
    }

    protected Object getExistingSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected Object getNotExistingSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract Object getSearchKey(String uuid);

    public abstract Resume[] getAll();

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doDelete(String uuid, Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

}

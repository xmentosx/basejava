package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage{

    protected final Map<String, Resume> storage = new HashMap<String, Resume>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return new Resume(uuid, "");
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        storage.put(((Resume)searchKey).getUuid(), resume);
    }

    @Override
    protected void doDelete(String uuid, Object searchKey) {
        storage.remove(((Resume)searchKey).getUuid());
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get(((Resume)searchKey).getUuid());
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage.put(((Resume) searchKey).getUuid(), resume);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey(((Resume) searchKey).getUuid());
    }

}

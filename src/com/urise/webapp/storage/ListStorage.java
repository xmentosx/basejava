package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage{

    protected final ArrayList<Resume> storage = new ArrayList<Resume>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume resume = new Resume(uuid);
        return storage.indexOf(resume);
    }

    @Override
    protected void saveToStorage(Resume resume, int receivedIndex) {
        storage.add(resume);
    }

    @Override
    protected void removeFromStorage(String uuid, int index) {
        storage.remove(index);
    }

    @Override
    protected Resume getOnIndex(int index) {
        return storage.get(index);
    }

    @Override
    protected void saveToIndex(Resume resume, int index) {
        storage.set(index, resume);
    }

    @Override
    protected void checkStorageOverflow(Resume resume) {

    }

}

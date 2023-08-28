package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        checkStorageOverflow(resume);
        int insertIndex = -1 * (int) searchKey - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = resume;
        size++;
    }

    @Override
    protected void doDelete(String uuid, Object searchKey) {
        int index = (int) searchKey;
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[--size] = null;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
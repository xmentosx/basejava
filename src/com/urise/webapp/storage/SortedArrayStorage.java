package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected void saveToStorage(Resume resume, int receivedIndex) {
        int insertIndex = -1 * receivedIndex - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = resume;
        size++;
    }

    @Override
    protected void removeFromStorage(String uuid, int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[--size] = null;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
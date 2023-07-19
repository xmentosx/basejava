package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume resume) {
        if (storage.length <= size) {
            System.out.println("Невозможно добавить резюме: Хранилище полностью заполнено.");
            return;
        }
        storage[size++] = resume;
    }

    public Resume get(String uuid) {
        int resumeIndex = findResumeIndex(uuid);
        if (resumeIndex == -1) {
            System.out.println("Невозможно получить резюме: Резюме не найдено в хранилище.");
            return null;
        }
        return storage[resumeIndex];
    }

    public void delete(String uuid) {
        int resumeIndex = findResumeIndex(uuid);
        if (resumeIndex == -1) {
            System.out.println("Невозможно удалить резюме: Резюме не найдено в хранилище.");
            return;
        }
        for (int i = resumeIndex + 1; i < size; i++) {
            storage[i - 1] = storage[i];
        }
        storage[--size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int findResumeIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}

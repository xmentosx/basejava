package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.Storage;
import com.urise.webapp.storage.SortedArrayStorage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new ArrayStorage();
    static final Storage SORTED_ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        test(ARRAY_STORAGE);
        System.out.print("\n------------------------\n\n");
        test(SORTED_ARRAY_STORAGE);
    }

    static void test(Storage arrayStorage) {
        System.out.printf("Test for %s\n\n", arrayStorage.getClass().getName());

        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r4 = new Resume("uuid4");

        arrayStorage.save(r3);
        arrayStorage.save(r2);
        arrayStorage.save(r1);

        System.out.println("Get r1: " + arrayStorage.get(r1.getUuid()));
        System.out.println("Size: " + arrayStorage.size());

        System.out.println("Get dummy: " + arrayStorage.get("dummy"));

        arrayStorage.update(r4);

        printAll(arrayStorage);
        arrayStorage.delete(r1.getUuid());
        printAll(arrayStorage);
        arrayStorage.clear();
        printAll(arrayStorage);

        System.out.println("Size: " + arrayStorage.size());

    }
    static void printAll(Storage arrayStorage) {
        System.out.println("\nGet All");
        for (Resume r : arrayStorage.getAll()) {
            System.out.println(r);
        }
    }
}

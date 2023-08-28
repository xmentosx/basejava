package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import org.junit.Assert;
import org.junit.Test;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        storage.clear();
        try {
            for (int i = 1; i <= 10000; i++) {
                storage.save(new Resume("uuid" + i));
            }
        } catch (StorageException e) {
            Assert.fail("Early storage overflow");
        }
        storage.save(new Resume("uuid10001"));
    }

    @Override
    protected void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

}
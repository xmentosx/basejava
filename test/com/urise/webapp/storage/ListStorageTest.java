package com.urise.webapp.storage;

import org.junit.Assert;

public class ListStorageTest extends AbstractStorageTest {
    public ListStorageTest() {
        super(new ListStorage());
    }

    @Override
    protected void assertSize(int size) {
    }
}
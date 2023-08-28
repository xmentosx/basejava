package com.urise.webapp.storage;

public class ListStorageTest extends AbstractStorageTest {
    public ListStorageTest() {
        super(new ListStorage());
    }

    @Override
    protected void assertSize(int size) {
    }
}
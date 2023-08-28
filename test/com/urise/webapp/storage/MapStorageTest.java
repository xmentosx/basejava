package com.urise.webapp.storage;

public class MapStorageTest extends AbstractStorageTest {
    public MapStorageTest() {
        super(new MapStorage());
    }

    @Override
    protected void assertSize(int size) {
    }
}
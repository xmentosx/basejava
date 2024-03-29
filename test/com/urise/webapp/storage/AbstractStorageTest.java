package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.urise.webapp.ResumeTestData.getResume;

public abstract class AbstractStorageTest {
    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_NOT_EXIST = "dummy";

    private static final String fullName_1 = "fullName1";
    private static final String fullName_2 = "fullName2";
    private static final String fullName_3 = "fullName3";
    private static final String fullName_4 = "fullName4";
    private static final String fullName_NOT_EXIST = "dummy";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = getResume(UUID_1, fullName_1);
        RESUME_2 = getResume(UUID_2, fullName_2);
        RESUME_3 = getResume(UUID_3, fullName_3);
        RESUME_4 = getResume(UUID_4, fullName_4);
    }

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    protected void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
        Resume[] resumes = storage.getAllSorted().toArray(new Resume[0]);
        Assert.assertArrayEquals(new Resume[0], resumes);
    }

    @Test
    public void update() throws Exception {
        Resume resume = getResume(UUID_1, fullName_1);
        storage.update(resume);
        Assert.assertSame(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        Resume resume = getResume(UUID_NOT_EXIST, fullName_NOT_EXIST);
        storage.update(resume);
    }

    @Test
    public void getAll() throws Exception {
        Resume[] actual = storage.getAllSorted().toArray(new Resume[0]);
        Resume[] expected = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        if (actual.length != expected.length) {
            Assert.fail("Arrays are not equal");
        }
        Set<Resume> actualSet = new HashSet<>();
        actualSet.addAll(Arrays.asList(actual));
        if (!actualSet.containsAll(Arrays.asList(expected))){
            Assert.fail("Arrays are not equal");
        }

    }

    @Test
    public void getAllSorted() throws Exception {
        Resume[] actual = storage.getAllSorted().toArray(new Resume[0]);
        Resume[] expected = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        if (!Arrays.equals(actual, expected)) {
            Assert.fail("Arrays are not equal");
        }
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(4);
    }

    @Test
    public void saveExist() throws Exception {
        try {
            storage.save(RESUME_1);
            Assert.fail("Resume " + UUID_1 + " is already exist");
        } catch (ExistStorageException e) {
            //OK
        }
        assertSize(3);
    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        try {
            storage.get(UUID_1);
            Assert.fail("Resume " + UUID_1 + " is not deleted");
        } catch (NotExistStorageException e) {
            //OK
        }
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_NOT_EXIST);
    }

    private void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_NOT_EXIST);
    }
}
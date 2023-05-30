import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume resume) {
        if (storage.length == size) {
            System.out.println("Невозможно добавить резюме: Хранилище полностью заполнено.");
            return;
        }
        storage[size++] = resume;
    }

    Resume get(String uuid) {
        int position = findResumePosition(uuid);
        if (position == -1) {
            System.out.println("Невозможно получить резюме: Резюме не найдено в хранилище.");
            return null;
        }
        return storage[position];
    }

    void delete(String uuid) {
        int position = findResumePosition(uuid);
        if (position == -1) {
            System.out.println("Невозможно удалить резюме: Резюме не найдено в хранилище.");
            return;
        }
        for (int i = position + 1; i < size; i++) {
            storage[i - 1] = storage[i];
        }
        storage[--size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    private int findResumePosition(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}

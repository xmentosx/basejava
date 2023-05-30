import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

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
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Невозможно получить резюме: Резюме не найдено в хранилище.");
        return null;
    }

    void delete(String uuid) {
        boolean resumeFound = false;
        for (int i = 0; i < size; i++) {
            if (resumeFound) {
                storage[i - 1] = storage[i];
            } else if (storage[i].uuid.equals(uuid)) {
                resumeFound = true;
            }
        }
        if (resumeFound) {
            storage[size--] = null;
        } else {
            System.out.println("Невозможно удалить резюме: Резюме не найдено в хранилище.");
        }
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
}

package core;

public interface Validatable<T> {
    void validate(T obj);
    default boolean isValid(T obj) {
        try {
            validate(obj);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
    static void requireNonNull(Object obj, String fieldName) {
        if (obj == null) {
            throw new IllegalArgumentException(fieldName + " must not be null");
        }
    }
}

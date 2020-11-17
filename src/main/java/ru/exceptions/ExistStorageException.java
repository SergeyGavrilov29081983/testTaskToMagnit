package ru.exceptions;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String id) {
        super("Model " + id + " already exist", id);
    }
}

package io.khasang.restaurant.exception;

public class DocumentNotFoundException extends Exception {
    public DocumentNotFoundException(String id) {
        super("DocumentNotFoundException with id = " + id);
    }
}

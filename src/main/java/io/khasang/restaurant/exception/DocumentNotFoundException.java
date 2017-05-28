package io.khasang.restaurant.exception;

/**
 * Created by firesome on 28.05.2017.
 */
public class DocumentNotFoundException extends Exception {
    public DocumentNotFoundException(String id) {
        super("DocumentNotFoundException with id = " + id);
    }
}

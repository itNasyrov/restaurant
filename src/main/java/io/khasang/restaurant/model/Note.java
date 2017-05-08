package io.khasang.restaurant.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Note {
    private String text;

    public Note() {
    }

    @Autowired
    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

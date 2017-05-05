package io.khasang.restaurant.model;

public class Message {
    private String name;
    int value;

    public Message() {
    }

    public Message(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVal() {
        return name.length();
    }
}

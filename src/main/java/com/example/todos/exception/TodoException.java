package com.example.todos.exception;

public class TodoException extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public TodoException(String message) {
        this.message = message;
    }

    public TodoException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }
}

package by.matthewvirus.apiworking.exceptions;

import java.io.IOException;

public class ResourceNotFoundException extends IOException {

    private final String message;

    public ResourceNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
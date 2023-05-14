package com.example.sidiayapi.exceptions;

import com.example.sidiayapi.utils.Logger;

public class NotYetImplementedException extends RuntimeException {
    public NotYetImplementedException(String message) {
        super(message);
    }
    public NotYetImplementedException() {
        super();
    }
}

package com.example.sidiayapi.exceptions;

import com.example.sidiayapi.utils.Logger;

public class NotYetImplementedException extends RuntimeException {
    public NotYetImplementedException(String message) {
        super(message);
    }
    public NotYetImplementedException() {
        super();
    }

    public NotYetImplementedException(Integer currentStatus, Integer newStatus, Boolean currentUserIsExecutor) {
        super ("New status: " + newStatus + " not supporting.");

        Logger.log("\nCurrent ticket status: " + currentStatus);
        if (currentUserIsExecutor) {
            Logger.log("Current user is executor");
        } else {
            Logger.log("Current user is author");
        }
        Logger.log("New status: " + newStatus + " not supporting.");
    }
}

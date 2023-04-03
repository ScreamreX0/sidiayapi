package com.example.sidiayapi.enums;

public enum StatusesEnum {
    NOT_FORMED(1),
    NEW(2),
    ACCEPTED(3),
    DENIED(4),
    SUSPENDED(5),
    COMPLETED(6),
    CLOSED(7),
    FOR_REVISION(8);

    public final int value;
    StatusesEnum(int value) {
        this.value = value;
    }
}

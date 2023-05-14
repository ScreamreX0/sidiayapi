package com.example.sidiayapi.enums;

public enum StatusesEnum {
    NOT_FORMED(1),
    NEW(2),
    EVALUATED(3),
    REJECTED(4),
    ACCEPTED(5),
    SUSPENDED(6),
    COMPLETED(7),
    QUALITY_CHECKING(8),
    CLOSED(9),
    FOR_REVISION(10),
    CANCELED(11);

    public final int value;
    StatusesEnum(int value) {
        this.value = value;
    }
}

package com.example.sidiayapi.enums;

import java.util.Arrays;

public enum StatusesEnum {
    NOT_FORMED(1),
    NEW(2),
    ACCEPTED(3),
    DENIED(4),
    STOPPED(5),
    COMPLETED(6),
    CLOSED(7),
    FOR_REVISION(8);

    public final int value;
    StatusesEnum(int value) {
        this.value = value;
    }

    public static StatusesEnum getByValue(int findingValue) {
        for (StatusesEnum status : StatusesEnum.values()) {
            if (status.value == findingValue) {
                return status;
            }
        }
        return null;
    }
}

package com.example.sidiayapi.enums;

public enum KindsEnum {
    PLANE(1),
    CURRENT(2),
    CAPITAL(3),
    TO(4),
    PPR(5),
    FLOODED(6),
    SLING_WORK(7);

    public final int value;

    KindsEnum(int value) {
        this.value = value;
    }
}

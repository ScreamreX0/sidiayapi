package com.example.sidiayapi.enums;

public enum PrioritiesEnum {
    VERY_LOW(1),
    LOW(2),
    MEDIUM(3),
    HIGH(4),
    URGENT(5);

    public final int value;

    PrioritiesEnum(int value) {
        this.value = value;
    }
}

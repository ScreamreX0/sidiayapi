package com.example.sidiayapi.utils;

import java.util.Objects;
import java.util.stream.Stream;

public class Validator {
    public static boolean anyNullOrBlank(String... values) {
        return Stream.of(values).anyMatch(Objects::isNull)
                || Stream.of(values).anyMatch(String::isBlank);
    }
    public static boolean anyNull(Object... values) {
        return Stream.of(values).anyMatch(Objects::isNull);
    }
}

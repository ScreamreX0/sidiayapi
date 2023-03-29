package com.example.sidiayapi.utils;

import java.util.Arrays;

public class Logger {
    public static void log(String... text) {
        Arrays.stream(text).forEach(it -> System.out.println("LOG: " + it));
    }
}

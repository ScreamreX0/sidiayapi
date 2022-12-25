package com.example.sidiayapi.utils;

import java.util.Arrays;

public class Logger {
    public static void log(String logTitle, StackTraceElement[] exceptionStacktrace) {
        System.out.println(logTitle);
        Arrays.stream(exceptionStacktrace).forEach(System.out::println);
    }
}

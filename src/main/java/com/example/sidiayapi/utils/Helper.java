package com.example.sidiayapi.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    public static <T> String arrToStr(List<T> arr) {
        return arr.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
    public static <T> String arrToStr(List<T> arr, String sep) {
        return arr.stream().map(String::valueOf).collect(Collectors.joining(sep));
    }
}

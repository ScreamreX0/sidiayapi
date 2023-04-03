package com.example.sidiayapi.utils;

import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.google.gson.Gson;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    public static <T> String arrToStr(List<T> arr) {
        return arr.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
    public static <T> String arrToStr(List<T> arr, String sep) {
        return arr.stream().map(String::valueOf).collect(Collectors.joining(sep));
    }

    public static void checkNewTicketStatus(List<Integer> allowedNewStatuses, Integer newTicketStatus) {
        if (newTicketStatus == null) {
            Logger.log("    ERROR. New ticket status is null");
            throw new WrongParamsException("    New ticket status is null");
        } else if (!allowedNewStatuses.contains(newTicketStatus)) {
            Logger.log("    ERROR. Wrong status: " + newTicketStatus
                    + ". Allowed values: " + Helper.arrToStr(allowedNewStatuses));
            throw new NotYetImplementedException("Status not yet implemented");
        }
    }
    public static void checkNewTicketStatus(Integer newTicketStatus) {
        if (newTicketStatus == null) {
            Logger.log("    ERROR. New ticket status is null");
            throw new WrongParamsException("    New ticket status is null");
        }
    }

    public static String convertObjectToString(Object object) {
        return new Gson().toJson(object);
    }
}

package com.example.fitapp;

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

public class StringListConverter {

    // convert list of strings to just a string
    @TypeConverter
    public String fromList(List<String> categories) {
        if (categories == null) {
            return null;
        }
        return String.join(",", categories);
    }

    // convert a string to list of strings
    @TypeConverter
    public List<String> toList(String categories) {
        if (categories == null) {
            return null;
        }
        return Arrays.asList(categories.split(","));
    }
}

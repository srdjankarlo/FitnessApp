package com.example.fitapp;

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converters {
    @TypeConverter
    public String fromList(List<String> categories) {
        if (categories == null) {
            return null;
        }
        return String.join(",", categories);
    }

    @TypeConverter
    public List<String> toList(String categories) {
        if (categories == null) {
            return null;
        }
        return Arrays.asList(categories.split(","));
    }
}

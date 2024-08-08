package com.example.fitapp;

import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateValueFormatter extends ValueFormatter {
    private final List<LocalDate> mDates;

    public DateValueFormatter(List<LocalDate> dates) {
        this.mDates = dates;
    }

    @Override
    public String getFormattedValue(float value) {
        int index = (int) value;
        if (index < 0 || index >= mDates.size()) {
            return "";
        }

        LocalDate date = mDates.get(index);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        return date.format(formatter);
    }
}
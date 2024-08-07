package com.example.fitapp;

import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateValueFormatter extends ValueFormatter {
    private final List<Long> mDates;

    public DateValueFormatter(List<Long> dates) {
        this.mDates = dates;
    }

    @Override
    public String getFormattedValue(float value) {
        int index = (int) value;
        if (index < 0 || index >= mDates.size()) {
            return "";
        }

        long dateInMillis = mDates.get(index);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        return sdf.format(new Date(dateInMillis));
    }
}
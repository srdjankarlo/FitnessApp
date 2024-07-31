package com.example.fitapp;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class BitmapListConverter {
    @TypeConverter
    public String fromBitmapList(ArrayList<Bitmap> bitmaps) {
        if (bitmaps == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (Bitmap bitmap : bitmaps) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(bitmapToString(bitmap));
        }
        return stringBuilder.toString();
    }

    @TypeConverter
    public ArrayList<Bitmap> toBitmapList(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] bitmapsAsString = data.split(",");
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        for (String bitmapAsString : bitmapsAsString) {
            bitmaps.add(stringToBitmap(bitmapAsString));
        }
        return bitmaps;
    }

    private String bitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    private Bitmap stringToBitmap(String encodedString) {
        byte[] decodedBytes = Base64.decode(encodedString, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }
}

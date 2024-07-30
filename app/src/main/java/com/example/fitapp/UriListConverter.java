package com.example.fitapp;
import android.net.Uri;
import androidx.room.TypeConverter;
import java.util.ArrayList;

public class UriListConverter {

    @TypeConverter
    public String fromUriList(ArrayList<Uri> uris) {
        if (uris == null || uris.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Uri uri : uris) {
            stringBuilder.append(uri.toString()).append(",");
        }
        // Remove the last comma
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    @TypeConverter
    public ArrayList<Uri> toUriList(String data) {
        if (data == null || data.isEmpty()) {
            return new ArrayList<>();
        }
        String[] uris = data.split(",");
        ArrayList<Uri> uriList = new ArrayList<>();
        for (String uriString : uris) {
            uriList.add(Uri.parse(uriString));
        }
        return uriList;
    }
}

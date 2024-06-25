package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OneExerciseRecViewItem implements Parcelable {

    //private SimpleDateFormat itemDate;
    private Date itemDate;
    private float itemWeight;
    private int itemReps;
    private int itemDuration;
    private int itemRest;

    public OneExerciseRecViewItem(Date date, float weight, int reps, int duration) {
        //this.itemDate = new SimpleDateFormat(date, Locale.getDefault());
        itemDate = date;
        itemWeight = weight;
        itemReps = reps;
        itemDuration = duration;
        itemRest = 0;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected OneExerciseRecViewItem(Parcel in){
        //String date = in.readString();
        //this.itemDate = new SimpleDateFormat(date, Locale.getDefault());
        long tmpDate = in.readLong();
        itemDate = tmpDate == -1 ? null : new Date(tmpDate);
        itemWeight = in.readFloat();
        itemReps = in.readInt();
        itemDuration = in.readInt();
        itemRest = in.readInt();
    }

    public static final Creator<OneExerciseRecViewItem> CREATOR = new Creator<OneExerciseRecViewItem>() {
        @Override
        public OneExerciseRecViewItem createFromParcel(Parcel parcel) {
            return new OneExerciseRecViewItem(parcel);
        }

        @Override
        public OneExerciseRecViewItem[] newArray(int i) {
            return new OneExerciseRecViewItem[i];
        }
    };

    public OneExerciseRecViewItem() {

    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        //dest.writeString(itemDate.toPattern());
        dest.writeLong(itemDate.getTime());
        //dest.writeString(itemDate);
        dest.writeFloat(itemWeight);
        dest.writeInt(itemReps);
        dest.writeInt(itemDuration);
        dest.writeInt(itemRest);
    }

    public Date getitemDate() {
        return itemDate;
    }

    public void setitemDate(Date date) {
        this.itemDate = date;
    }

    public float getitemWeight() {
        return itemWeight;
    }

    public void setitemWeight(float weight) {
        this.itemWeight = weight;
    }

    public int getitemReps() {
        return itemReps;
    }

    public void setitemReps(int reps) {
        itemReps = reps;
    }

    public int getitemDuration() {
        return itemDuration;
    }

    public void setitemDuration(int duration) {
        itemDuration = duration;
    }

    public int getitemRest() {
        return itemRest;
    }

    public void setitemRest(int rest) {
        itemRest = rest;
    }


    @NonNull
    @Override
    public String toString() {
        return "OneExerciseRecViewItem{" +
                "Date='" + itemDate + '\'' +
                ", Weight=" + itemWeight + '\'' +
                ", Reps=" + itemReps + '\'' +
                ", Duration=" + itemDuration + '\'' +
                ", Rest=" + itemRest + '\'' +
                '}';
    }
}

package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class OneExerciseRecViewItem implements Parcelable {

    //private SimpleDateFormat oneExerciseRecViewDate;
    private String oneExerciseRecViewDate;
    private String oneExerciseRecViewWeight;
    private String oneExerciseRecViewReps;
    private String oneExerciseRecViewDuration;
    private String oneExerciseRecViewRest;

    public OneExerciseRecViewItem(String date, String weight, String reps, String duration) {
        //this.oneExerciseRecViewDate = new SimpleDateFormat(date, Locale.getDefault());
        oneExerciseRecViewDate = date;
        oneExerciseRecViewWeight = weight;
        oneExerciseRecViewReps = reps;
        oneExerciseRecViewDuration = duration;
        oneExerciseRecViewRest = "-";
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected OneExerciseRecViewItem(Parcel in){
        //String date = in.readString();
        //this.oneExerciseRecViewDate = new SimpleDateFormat(date, Locale.getDefault());
        oneExerciseRecViewDate = in.readString();
        oneExerciseRecViewWeight = in.readString();
        oneExerciseRecViewReps = in.readString();
        oneExerciseRecViewDuration = in.readString();
        oneExerciseRecViewRest = in.readString();
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
        //dest.writeString(oneExerciseRecViewDate.toPattern());
        dest.writeString(oneExerciseRecViewDate);
        dest.writeString(oneExerciseRecViewWeight);
        dest.writeString(oneExerciseRecViewReps);
        dest.writeString(oneExerciseRecViewDuration);
        dest.writeString(oneExerciseRecViewRest);
    }

    public String getOneExerciseRecViewDate() {
        return oneExerciseRecViewDate;
    }

    public void setOneExerciseRecViewDate(String date) {
        this.oneExerciseRecViewDate = date;
    }

    public String getOneExerciseRecViewWeight() {
        return oneExerciseRecViewWeight;
    }

    public void setOneExerciseRecViewWeight(String weight) {
        this.oneExerciseRecViewWeight = weight;
    }

    public String getOneExerciseRecViewReps() {
        return oneExerciseRecViewReps;
    }

    public void setOneExerciseRecViewReps(String reps) {
        oneExerciseRecViewReps = reps;
    }

    public String getOneExerciseRecViewDuration() {
        return oneExerciseRecViewDuration;
    }

    public void setOneExerciseRecViewDuration(String duration) {
        oneExerciseRecViewDuration = duration;
    }

    public String getOneExerciseRecViewRest() {
        return oneExerciseRecViewRest;
    }

    public void setOneExerciseRecViewRest(String rest) {
        oneExerciseRecViewRest = rest;
    }


    @NonNull
    @Override
    public String toString() {
        return "OneExerciseRecViewItem{" +
                "Date='" + oneExerciseRecViewDate + '\'' +
                ", Weight=" + oneExerciseRecViewWeight + '\'' +
                ", Reps=" + oneExerciseRecViewReps + '\'' +
                ", Duration=" + oneExerciseRecViewDuration + '\'' +
                ", Rest=" + oneExerciseRecViewRest + '\'' +
                '}';
    }
}

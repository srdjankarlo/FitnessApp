package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "one_exercise_table")
public class OneExerciseItem implements Parcelable {

    //private SimpleDateFormat itemDate;
    private String exerciseName;
    @PrimaryKey
    @NonNull
    private long itemDate;
    private float itemWeight;
    private int itemReps;
    private int itemDuration;
    private int itemRest;

    public OneExerciseItem(String exerciseName, long date, float weight, int reps, int work_duration, int rest_duration) {
        //this.itemDate = new SimpleDateFormat(date, Locale.getDefault());
        this.exerciseName = exerciseName;
        itemDate = date;
        itemWeight = weight;
        itemReps = reps;
        itemDuration = work_duration;
        itemRest = rest_duration;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected OneExerciseItem(Parcel in){
        //String date = in.readString();
        //this.itemDate = new SimpleDateFormat(date, Locale.getDefault());
        //long tmpDate = in.readLong();
        //itemDate = tmpDate == -1 ? null : new Date(tmpDate);

        exerciseName = in.readString();
        itemDate = in.readLong();
        itemWeight = in.readFloat();
        itemReps = in.readInt();
        itemDuration = in.readInt();
        itemRest = in.readInt();
    }

    public static final Creator<OneExerciseItem> CREATOR = new Creator<OneExerciseItem>() {
        @Override
        public OneExerciseItem createFromParcel(Parcel parcel) {
            return new OneExerciseItem(parcel);
        }

        @Override
        public OneExerciseItem[] newArray(int i) {
            return new OneExerciseItem[i];
        }
    };

    public OneExerciseItem() {

    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        //dest.writeString(itemDate.toPattern());
        //dest.writeLong(itemDate.getTime());
        dest.writeString(exerciseName);
        dest.writeLong(itemDate);
        //dest.writeString(itemDate);
        dest.writeFloat(itemWeight);
        dest.writeInt(itemReps);
        dest.writeInt(itemDuration);
        dest.writeInt(itemRest);
    }

    public String getExerciseName(){return exerciseName;}
    public  void setExerciseName(String exerciseName){this.exerciseName = exerciseName;}

    public long getItemDate() {
        return itemDate;
    }

    public void setItemDate(long date) {
        this.itemDate = date;
    }

    public float getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(float weight) {
        this.itemWeight = weight;
    }

    public int getItemReps() {
        return itemReps;
    }

    public void setItemReps(int reps) {
        itemReps = reps;
    }

    public int getItemDuration() {
        return itemDuration;
    }

    public void setItemDuration(int duration) {
        itemDuration = duration;
    }

    public int getItemRest() {
        return itemRest;
    }

    public void setItemRest(int rest) {
        itemRest = rest;
    }

    @NonNull
    @Override
    public String toString() {
        return "OneExerciseItem{" +
                " Name='" + exerciseName + '\'' +
                " Date='" + itemDate + '\'' +
                ", Weight=" + itemWeight + '\'' +
                ", Reps=" + itemReps + '\'' +
                ", Duration=" + itemDuration + '\'' +
                ", Rest=" + itemRest + '\'' +
                '}';
    }
}

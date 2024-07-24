package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import java.util.Objects;

public class MuscleGroupsItem implements Parcelable {
    @DrawableRes
    private int image;
    private String name;
    private int numberOfExercises;

    public MuscleGroupsItem(@DrawableRes int image, String name, int numberOfExercises) {
        this.image = image;
        this.name = name;
        this.numberOfExercises = numberOfExercises;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected MuscleGroupsItem(Parcel in){
        image = in.readInt();
        name = in.readString();
        numberOfExercises = in.readInt();
    }

    public static final Creator<MuscleGroupsItem> CREATOR = new Creator<MuscleGroupsItem>() {
        @Override
        public MuscleGroupsItem createFromParcel(Parcel parcel) {
            return new MuscleGroupsItem(parcel);
        }

        @Override
        public MuscleGroupsItem[] newArray(int i) {
            return new MuscleGroupsItem[i];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeInt(numberOfExercises);
    }

    @DrawableRes
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfExercises() {
        return numberOfExercises;
    }

    public void setNumberOfExercises(int numberOfExercises) {
        this.numberOfExercises = numberOfExercises;
    }

    @NonNull
    @Override
    public String toString() {
        return "MainMenuRecViewItem{" +
                "CommonRecViewName='" + name + '\'' +
                ", CommonRecViewImage=" + image + '\'' +
                ", CommonRecViewNumOfEx=" + numberOfExercises + '\'' +
                '}';
    }
}

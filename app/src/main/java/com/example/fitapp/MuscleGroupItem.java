package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class MuscleGroupItem implements Parcelable {
    @DrawableRes
    private int image;
    private String muscleGroup;
    private String name;

    public MuscleGroupItem(@DrawableRes int image, String muscleGroup, String name) {
        this.image = image;
        this.muscleGroup = muscleGroup;
        this.name = name;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected MuscleGroupItem(Parcel in){
        image = in.readInt();
        muscleGroup = in.readString();
        name = in.readString();
    }

    public static final Creator<MuscleGroupItem> CREATOR = new Creator<MuscleGroupItem>() {
        @Override
        public MuscleGroupItem createFromParcel(Parcel parcel) {
            return new MuscleGroupItem(parcel);
        }

        @Override
        public MuscleGroupItem[] newArray(int i) {
            return new MuscleGroupItem[i];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(image);
        dest.writeString(muscleGroup);
        dest.writeString(name);
    }

    @DrawableRes
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "MainMenuRecViewItem{" +
                "CommonRecViewName='" + name + '\'' +
                ", CommonRecViewImage=" + image + '\'' +
                '}';
    }
}

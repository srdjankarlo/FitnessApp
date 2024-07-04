package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "exercises_table")
@TypeConverters(Converters.class)
public class ExercisesItem implements Parcelable {
    @DrawableRes
    private int image;
    private String muscleGroup;
    private List<String> categories;  // more muscle groups, should replace muscleGroup
    @PrimaryKey
    @NonNull
    private String exerciseName;

    // Default no-argument constructor
    public ExercisesItem() {
        exerciseName = null;
    }

    public ExercisesItem(@DrawableRes int image, String muscleGroup, List<String> category, @NonNull String exerciseName) {
        this.image = image;
        this.muscleGroup = muscleGroup;
        this.categories = category;
        this.exerciseName = exerciseName;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected ExercisesItem(Parcel in){
        image = in.readInt();
        muscleGroup = in.readString();
        categories = in.createStringArrayList();
        exerciseName = in.readString();
    }

    public static final Creator<ExercisesItem> CREATOR = new Creator<ExercisesItem>() {
        @Override
        public ExercisesItem createFromParcel(Parcel parcel) {
            return new ExercisesItem(parcel);
        }

        @Override
        public ExercisesItem[] newArray(int i) {
            return new ExercisesItem[i];
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
        dest.writeStringList(categories);
        dest.writeString(exerciseName);
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

    public List<String> getCategories(){return categories;}

    public void setCategories(List<String> categories){this.categories = categories;}

    @NonNull
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(@NonNull String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @NonNull
    @Override
    public String toString() {
        return "MainMenuRecViewItem{" +
                ", RecViewImage=" + image + '\'' +
                ", RecViewImage=" + muscleGroup + '\'' +
                ", RecViewImage=" + categories + '\'' +
                ", RecViewName='" + exerciseName + '\'' +
                '}';
    }
}

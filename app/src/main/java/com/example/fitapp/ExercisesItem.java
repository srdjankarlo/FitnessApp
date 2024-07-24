package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


import java.util.List;

@Entity(tableName = "exercises_table")
@TypeConverters(Converters.class)
public class ExercisesItem implements Parcelable {
    @DrawableRes
    private int image;
    @PrimaryKey
    @NonNull
    private String exerciseName;
    private List<String> categories;  // more muscle groups, should replace muscleGroup

    // Default no-argument constructor
    public ExercisesItem() {
        exerciseName = "Generic Name";
    }

    public ExercisesItem(@DrawableRes int image, @NonNull String exerciseName, List<String> category) {
        this.image = image;
        this.exerciseName = exerciseName;
        this.categories = category;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected ExercisesItem(Parcel in){
        image = in.readInt();
        exerciseName = in.readString();
        categories = in.createStringArrayList();
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
        dest.writeString(exerciseName);
        dest.writeStringList(categories);
    }

    @DrawableRes
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @NonNull
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(@NonNull String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public List<String> getCategories(){return categories;}

    public void setCategories(List<String> categories){this.categories = categories;}


    @NonNull
    @Override
    public String toString() {
        return "MainMenuRecViewItem{" +
                ", RecViewImage=" + image + '\'' +
                ", RecViewName='" + exerciseName + '\'' +
                ", RecViewCategories=" + categories + '\'' +
                '}';
    }
}

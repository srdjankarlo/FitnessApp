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
    private List<String> categories;  // more muscle groups

    int num_chest_exercises;
    int num_shoulders_exercises;
    int num_biceps_exercises;
    int num_triceps_exercises;
    int num_forearms_exercises;
    int num_back_exercises;
    int num_abs_exercises;
    int num_quads_exercises;
    int num_hamstrings_exercises;
    int num_glutes_exercises;
    int num_calves_exercises;
    boolean customExercise;  // true if this is custom added exercise, in order so we can delete just the custom exercises and leave the in app exercises
    // String explanation;  // ToDo: this is for future

    // Default no-argument constructor
    public ExercisesItem() {
        exerciseName = "Generic Name";
    }

    public ExercisesItem(@DrawableRes int image, @NonNull String exerciseName, List<String> categories, boolean customExercise) {
        this.image = image;
        this.exerciseName = exerciseName;
        this.categories = categories;
        this.customExercise = customExercise;
        //this.explanation = explanation;

        for (String category : categories){
            if (category.equals("Chest")){
                num_chest_exercises += 1;
            } else if (category.equals("Shoulders")) {
                num_shoulders_exercises += 1;
            } else if (category.equals("Biceps")) {
                num_biceps_exercises += 1;
            } else if (category.equals("Triceps")) {
                num_triceps_exercises += 1;
            } else if (category.equals("Forearms")) {
                num_forearms_exercises += 1;
            } else if (category.equals("Back")) {
                num_back_exercises += 1;
            } else if (category.equals("Abs")) {
                num_abs_exercises += 1;
            } else if (category.equals("Quads")) {
                num_quads_exercises += 1;
            } else if (category.equals("Hamstrings")) {
                num_hamstrings_exercises += 1;
            } else if (category.equals("Glutes")) {
                num_glutes_exercises += 1;
            } else if (category.equals("Calves")) {
                num_calves_exercises += 1;
            }
        }
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

    public boolean isCustomExercise() {
        return customExercise;
    }

    public int getNum_chest_exercises() {
        return num_chest_exercises;
    }

    public int getNum_shoulders_exercises() {
        return num_shoulders_exercises;
    }

    public int getNum_biceps_exercises() {
        return num_biceps_exercises;
    }

    public int getNum_triceps_exercises() {
        return num_triceps_exercises;
    }

    public int getNum_forearms_exercises() {
        return num_forearms_exercises;
    }

    public int getNum_back_exercises() {
        return num_back_exercises;
    }

    public int getNum_abs_exercises() {
        return num_abs_exercises;
    }

    public int getNum_quads_exercises() {
        return num_quads_exercises;
    }

    public int getNum_hamstrings_exercises() {
        return num_hamstrings_exercises;
    }

    public int getNum_glutes_exercises() {
        return num_glutes_exercises;
    }

    public int getNum_calves_exercises() {
        return num_calves_exercises;
    }

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

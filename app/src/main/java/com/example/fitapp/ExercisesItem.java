package com.example.fitapp;

import android.net.Uri;
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
public class ExercisesItem implements Parcelable {
    @DrawableRes
    private int muscle_image;
    @PrimaryKey
    @NonNull
    private String exerciseName;

    @TypeConverters(StringListConverter.class)
    private List<String> primary;  // more muscle groups

    @TypeConverters(StringListConverter.class)
    private List<String> secondary;  // more muscle groups

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
    String explanation;  // ToDo: this is for future

    @TypeConverters(UriListConverter.class)
    ArrayList<Uri> workout_images;

    String place;

    // Default no-argument constructor
    public ExercisesItem() {
        exerciseName = "Generic Name";
    }

    public ExercisesItem(@DrawableRes int muscle_image, @NonNull String exerciseName,
                         List<String> categories1, List<String> categories2, boolean customExercise,
                         String explanation, ArrayList<Uri> images, String place) {
        this.muscle_image = muscle_image;
        this.exerciseName = exerciseName;
        this.primary = categories1;
        this.secondary = categories2;
        this.customExercise = customExercise;
        this.explanation = explanation;

        // ToDo: Option 2: Pass the URI Instead of Bitmap: https://chatgpt.com/c/a9b4a717-1924-4472-8a3f-4aa8a38d105d
        // ToDo: maybe store Uri as string in object
        if (images == null){
            this.workout_images = new ArrayList<>();
        } else {
            this.workout_images = images;
        }

        this.place = place;

        for (String category : primary){
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
        muscle_image = in.readInt();
        exerciseName = in.readString();
        primary = in.createStringArrayList();
        secondary = in.createStringArrayList();
        customExercise = in.readBoolean();
        explanation = in.readString();
        //images = in.createTypedArrayList(Bitmap.CREATOR);
        workout_images = in.createTypedArrayList(Uri.CREATOR);  // for ArrayList<Uri>
        //image = in.readParcelable(Uri.class.getClassLoader());  // for Uri
        //image = in.readInt();
        place = in.readString();
    }

    public static final Creator<ExercisesItem> CREATOR = new Creator<ExercisesItem>() {
        @Override
        public ExercisesItem createFromParcel(Parcel parcel) {
            return new ExercisesItem(parcel);
        }

        @Override
        public ExercisesItem[] newArray(int size) {
            return new ExercisesItem[size];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(muscle_image);
        dest.writeString(exerciseName);
        dest.writeStringList(primary);
        dest.writeStringList(secondary);
        dest.writeBoolean(customExercise);
        dest.writeString(explanation);
        dest.writeTypedList(workout_images);  // for ArrayList<Uri> and ArrayList<Bitmap>
        //dest.writeParcelable(image, flags);  // for Uri
        //dest.writeInt(image);
        dest.writeString(place);
    }

    @DrawableRes
    public int getMuscle_image() {
        return muscle_image;
    }

    public void setMuscle_image(int image) {
        this.muscle_image = image;
    }

    @NonNull
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(@NonNull String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public List<String> getPrimary(){return primary;}

    public void setPrimary(List<String> primary){this.primary = primary;}

    public List<String> getSecondary() {
        return secondary;
    }

    public void setSecondary(List<String> secondary) {
        this.secondary = secondary;
    }

    public boolean getCustomExercise() {
        return customExercise;
    }

    public void setCustomExercise(boolean customExercise) {
        this.customExercise = customExercise;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public ArrayList<Uri> getWorkout_images() {
        return workout_images;
    }

    public void setWorkout_images(ArrayList<Uri> workout_images) {
        this.workout_images = workout_images;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
                ", RecViewImage=" + muscle_image + '\'' +
                ", RecViewName='" + exerciseName + '\'' +
                ", RecViewCategories=" + primary + '\'' +
                '}';
    }
}

package com.example.fitapp;

import androidx.annotation.DrawableRes;

public class ChestExercise {
    private String nameChestExercise;
    @DrawableRes
    private int imageChestExercise;

    public ChestExercise(String name, @DrawableRes int image) {
        this.nameChestExercise = name;
        this.imageChestExercise = image;
    }

    public String getNameChestExercise() {
        return nameChestExercise;
    }

    public void setNameChestExercise(String name) {
        this.nameChestExercise = name;
    }

    @DrawableRes
    public int getImageChestExercise() {
        return imageChestExercise;
    }

    public void setImageChestExercise(int image) {
        this.imageChestExercise = image;
    }

    @Override
    public String toString() {
        return "MuscleGroup{" +
                "nameMuscleGroup='" + nameChestExercise + '\'' +
                ", imageMuscleGroup=" + imageChestExercise +
                '}';
    }
}

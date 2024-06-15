package com.example.fitapp;

import androidx.annotation.DrawableRes;

public class MuscleGroup {
    private String nameMuscleGroup;
    @DrawableRes
    private int imageMuscleGroup;

    public MuscleGroup(String name, @DrawableRes int image) {
        this.nameMuscleGroup = name;
        this.imageMuscleGroup = image;
    }

    public String getNameMuscleGroup() {
        return nameMuscleGroup;
    }

    public void setNameMuscleGroup(String name) {
        this.nameMuscleGroup = name;
    }

    @DrawableRes
    public int getImageMuscleGroup() {
        return imageMuscleGroup;
    }

    public void setImageMuscleGroup(int image) {
        this.imageMuscleGroup = image;
    }

    @Override
    public String toString() {
        return "MuscleGroup{" +
                "nameMuscleGroup='" + nameMuscleGroup + '\'' +
                ", imageMuscleGroup=" + imageMuscleGroup +
                '}';
    }
}

package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DietRecViewItem implements Parcelable {

    //private SimpleDateFormat food_name;
    private String food_name;
    private String proteins;
    private String fats;
    private String carbohydrates;
    private String sugars;

    public DietRecViewItem(String name, String protein, String fat, String carbs, String sugar) {
        //this.food_name = new SimpleDateFormat(date, Locale.getDefaultsugar;
        food_name = name;
        proteins = protein;
        fats = fat;
        carbohydrates = carbs;
        sugars = sugar;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected DietRecViewItem(Parcel in){
        //String date = in.readString();
        //this.food_name = new SimpleDateFormat(date, Locale.getDefault());
        this.food_name = in.readString();
        this.proteins = in.readString();
        this.fats = in.readString();
        this.carbohydrates = in.readString();
        this.sugars = in.readString();
    }

    public static final Creator<DietRecViewItem> CREATOR = new Creator<DietRecViewItem>() {
        @Override
        public DietRecViewItem createFromParcel(Parcel parcel) {
            return new DietRecViewItem(parcel);
        }

        @Override
        public DietRecViewItem[] newArray(int i) {
            return new DietRecViewItem[i];
        }
    };

    public DietRecViewItem() {
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        //dest.writeString(food_name.toPattern());
        dest.writeString(food_name);
        dest.writeString(proteins);
        dest.writeString(fats);
        dest.writeString(carbohydrates);
        dest.writeString(sugars);
    }

    public String getfood_name() {
        return food_name;
    }

    public void setfood_name(String food) {
        this.food_name = food;
    }

    public String getprotein() {
        return proteins;
    }

    public void setprotein(String protein) {
        this.proteins = protein;
    }

    public String getfat() {
        return fats;
    }

    public void setfat(String fat) {
        this.fats = fat;
    }

    public String getcarbohydrates() {
        return carbohydrates;
    }

    public void setcarbohydrates(String carbs) {
        this.carbohydrates = carbs;
    }

    public String getsugar() {
        return sugars;
    }

    public void setsugar(String sugar) {
        this.sugars = sugar;
    }


    @NonNull
    @Override
    public String toString() {
        return "DietRecViewItem{" +
                "Food='" + food_name + '\'' +
                ", Protein=" + proteins + '\'' +
                ", Fat=" + fats + '\'' +
                ", Carbs=" + carbohydrates + '\'' +
                ", Sugar=" + sugars + '\'' +
                '}';
    }
}

package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class DietItem implements Parcelable {

    private Date date;
    private String food_name;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private int sugars;

    public DietItem(Date this_date, String name, int protein, int fat, int carbs, int sugar) {
        date = this_date;
        food_name = name;
        proteins = protein;
        fats = fat;
        carbohydrates = carbs;
        sugars = sugar;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected DietItem(Parcel in){
        //String date = in.readString();
        //this.food_name = new SimpleDateFormat(date, Locale.getDefault());
        long tmpDate = in.readLong();
        date = tmpDate == -1 ? null : new Date(tmpDate);
        this.food_name = in.readString();
        this.proteins = in.readInt();
        this.fats = in.readInt();
        this.carbohydrates = in.readInt();
        this.sugars = in.readInt();
    }

    public static final Creator<DietItem> CREATOR = new Creator<DietItem>() {
        @Override
        public DietItem createFromParcel(Parcel parcel) {
            return new DietItem(parcel);
        }

        @Override
        public DietItem[] newArray(int i) {
            return new DietItem[i];
        }
    };

    public DietItem() {
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        //dest.writeString(food_name.toPattern());
        dest.writeLong(date.getTime());
        dest.writeString(food_name);
        dest.writeInt(proteins);
        dest.writeInt(fats);
        dest.writeInt(carbohydrates);
        dest.writeInt(sugars);
    }

    public Date getDate(){return date;}

    public void setDate(Date this_date){this.date = this_date;}

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food) {
        this.food_name = food;
    }

    public int getProtein() {
        return proteins;
    }

    public void setProtein(int protein) {
        this.proteins = protein;
    }

    public int getFat() {
        return fats;
    }

    public void setFat(int fat) {
        this.fats = fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbs) {
        this.carbohydrates = carbs;
    }

    public int getSugar() {
        return sugars;
    }

    public void setSugar(int sugar) {
        this.sugars = sugar;
    }


    @NonNull
    @Override
    public String toString() {
        return "DietItem{" +
                "Date='" + date + '\'' +
                ", Food='" + food_name + '\'' +
                ", Protein=" + proteins + '\'' +
                ", Fat=" + fats + '\'' +
                ", Carbs=" + carbohydrates + '\'' +
                ", Sugar=" + sugars + '\'' +
                '}';
    }
}

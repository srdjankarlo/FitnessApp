package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Parcelable is in order to be able to send DietItem objext to another activity
@Entity(tableName = "diet_table")
public class DietItem implements Parcelable {

    // ToDo: see when you learn how to plot, will date be good wor x axis and how to get that data
    @PrimaryKey
    private long date;
    private String food_name;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private int calories;

    public DietItem(long this_date, String name, int protein, int fat, int carbs, int calorie) {
        date = this_date;
        food_name = name;
        proteins = protein;
        fats = fat;
        carbohydrates = carbs;
        calories = calorie;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected DietItem(Parcel in){
        //String date = in.readString();
        //this.food_name = new SimpleDateFormat(date, Locale.getDefault());

        //long tmpDate = in.readLong();
        //date = tmpDate == -1 ? null : new Date(tmpDate);

        this.date = in.readLong();
        this.food_name = in.readString();
        this.proteins = in.readInt();
        this.fats = in.readInt();
        this.carbohydrates = in.readInt();
        this.calories = in.readInt();
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
        //dest.writeLong(date.getTime());
        dest.writeLong(date);
        dest.writeString(food_name);
        dest.writeInt(proteins);
        dest.writeInt(fats);
        dest.writeInt(carbohydrates);
        dest.writeInt(calories);
    }

    public long getDate(){return date;}

    public void setDate(long this_date){this.date = this_date;}

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food) {
        this.food_name = food;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int protein) {
        this.proteins = protein;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fat) {
        this.fats = fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbs) {
        this.carbohydrates = carbs;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calorie) {
        this.calories = calorie;
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
                ", Sugar=" + calories + '\'' +
                '}';
    }
}

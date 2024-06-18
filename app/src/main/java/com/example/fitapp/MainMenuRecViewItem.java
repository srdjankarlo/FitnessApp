package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class MainMenuRecViewItem implements Parcelable {
    @DrawableRes
    private int MainMenuViewImageView1;
    private String MainMenuRecViewTextView1;
    private String MainMenuRecViewTextView2;
    private String MainMenuRecViewType;

    public MainMenuRecViewItem(@DrawableRes int image, String name, String type, String text) {
        this.MainMenuViewImageView1 = image;
        this.MainMenuRecViewTextView1 = name;
        this.MainMenuRecViewType = type;
        this.MainMenuRecViewTextView2 = text;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected MainMenuRecViewItem(Parcel in){
        MainMenuViewImageView1 = in.readInt();
        MainMenuRecViewTextView1 = in.readString();
        MainMenuRecViewType = in.readString();
        MainMenuRecViewTextView2 = in.readString();
    }

    public static final Creator<MainMenuRecViewItem> CREATOR = new Creator<MainMenuRecViewItem>() {
        @Override
        public MainMenuRecViewItem createFromParcel(Parcel parcel) {
            return new MainMenuRecViewItem(parcel);
        }

        @Override
        public MainMenuRecViewItem[] newArray(int i) {
            return new MainMenuRecViewItem[i];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(MainMenuViewImageView1);
        dest.writeString(MainMenuRecViewTextView1);
        dest.writeString(MainMenuRecViewType);
        dest.writeString(MainMenuRecViewTextView2);
    }

    public String getMainMenuRecViewTextView1() {
        return MainMenuRecViewTextView1;
    }

    public void setMainMenuRecViewTextView1(String name) {
        this.MainMenuRecViewTextView1 = name;
    }

    @DrawableRes
    public int getMainMenuViewImageView1() {
        return MainMenuViewImageView1;
    }

    public void setMainMenuViewImageView1(int image) {
        this.MainMenuViewImageView1 = image;
    }

    public String getMainMenuRecViewType() {
        return MainMenuRecViewType;
    }

    public void setMainMenuRecViewType(String mainMenuRecViewType) {
        MainMenuRecViewType = mainMenuRecViewType;
    }

    public String getMainMenuRecViewTextView2() {
        return MainMenuRecViewTextView2;
    }

    public void setMainMenuRecViewTextView2(String mainMenuRecViewTextView2) {
        MainMenuRecViewTextView2 = mainMenuRecViewTextView2;
    }

    @NonNull
    @Override
    public String toString() {
        return "MainMenuRecViewItem{" +
                "CommonRecViewName='" + MainMenuRecViewTextView1 + '\'' +
                ", CommonRecViewImage=" + MainMenuViewImageView1 + '\'' +
                ", CommonRecViewType=" + MainMenuRecViewType + '\'' +
                ", CommonRecViewTextView2=" + MainMenuRecViewTextView2 + '\'' +
                '}';
    }
}

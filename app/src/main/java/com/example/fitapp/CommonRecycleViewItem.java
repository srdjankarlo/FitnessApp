package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class CommonRecycleViewItem implements Parcelable {
    @DrawableRes
    private int CommonRecViewImageView1;
    private String CommonRecViewTextView1;
    private String CommonRecViewTextView2;
    private String CommonRecViewType;

    public CommonRecycleViewItem(@DrawableRes int image, String name, String type, String text) {
        this.CommonRecViewImageView1 = image;
        this.CommonRecViewTextView1 = name;
        this.CommonRecViewType = type;
        this.CommonRecViewTextView2 = text;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected CommonRecycleViewItem(Parcel in){
        CommonRecViewImageView1 = in.readInt();
        CommonRecViewTextView1 = in.readString();
        CommonRecViewType = in.readString();
        CommonRecViewTextView2 = in.readString();
    }

    public static final Creator<CommonRecycleViewItem> CREATOR = new Creator<CommonRecycleViewItem>() {
        @Override
        public CommonRecycleViewItem createFromParcel(Parcel parcel) {
            return new CommonRecycleViewItem(parcel);
        }

        @Override
        public CommonRecycleViewItem[] newArray(int i) {
            return new CommonRecycleViewItem[i];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(CommonRecViewImageView1);
        dest.writeString(CommonRecViewTextView1);
        dest.writeString(CommonRecViewType);
        dest.writeString(CommonRecViewTextView2);
    }

    public String getCommonRecViewTextView1() {
        return CommonRecViewTextView1;
    }

    public void setCommonRecViewTextView1(String name) {
        this.CommonRecViewTextView1 = name;
    }

    @DrawableRes
    public int getCommonRecViewImageView1() {
        return CommonRecViewImageView1;
    }

    public void setCommonRecViewImageView1(int image) {
        this.CommonRecViewImageView1 = image;
    }

    public String getCommonRecViewType() {
        return CommonRecViewType;
    }

    public void setCommonRecViewType(String commonRecViewType) {
        CommonRecViewType = commonRecViewType;
    }

    public String getCommonRecViewTextView2() {
        return CommonRecViewTextView2;
    }

    public void setCommonRecViewTextView2(String commonRecViewTextView2) {
        CommonRecViewTextView2 = commonRecViewTextView2;
    }

    @NonNull
    @Override
    public String toString() {
        return "CommonRecycleViewItem{" +
                "CommonRecViewName='" + CommonRecViewTextView1 + '\'' +
                ", CommonRecViewImage=" + CommonRecViewImageView1 + '\'' +
                ", CommonRecViewType=" + CommonRecViewType + '\'' +
                ", CommonRecViewTextView2=" + CommonRecViewTextView2 + '\'' +
                '}';
    }
}

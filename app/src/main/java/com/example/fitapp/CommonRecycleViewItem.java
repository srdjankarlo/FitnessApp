package com.example.fitapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class CommonRecycleViewItem implements Parcelable {
    private String CommonRecViewName;
    @DrawableRes
    private int CommonRecViewImage;
    private String CommonRecViewType;

    public CommonRecycleViewItem(String name, @DrawableRes int image, String type) {
        this.CommonRecViewName = name;
        this.CommonRecViewImage = image;
        this.CommonRecViewType = type;
    }

    // next 4 methods are implemented because of passing custom data as intent to other activities
    protected CommonRecycleViewItem(Parcel in){
        CommonRecViewName = in.readString();
        CommonRecViewImage = in.readInt();
        CommonRecViewType = in.readString();
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
        dest.writeString(CommonRecViewName);
        dest.writeInt(CommonRecViewImage);
        dest.writeString(CommonRecViewType);
    }

    public String getCommonRecViewName() {
        return CommonRecViewName;
    }

    public void setCommonRecViewName(String name) {
        this.CommonRecViewName = name;
    }

    @DrawableRes
    public int getCommonRecViewImage() {
        return CommonRecViewImage;
    }

    public void setCommonRecViewImage(int image) {
        this.CommonRecViewImage = image;
    }

    public String getCommonRecViewType() {
        return CommonRecViewType;
    }

    public void setCommonRecViewType(String commonRecViewType) {
        CommonRecViewType = commonRecViewType;
    }

    @NonNull
    @Override
    public String toString() {
        return "CommonRecycleViewItem{" +
                "CommonRecViewName='" + CommonRecViewName + '\'' +
                ", CommonRecViewImage=" + CommonRecViewImage + '\'' +
                ", CommonRecViewType=" + CommonRecViewType +
                '}';
    }
}

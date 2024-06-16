package com.example.fitapp;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class CommonRecycleViewItem {
    private String CommonRecViewName;
    @DrawableRes
    private int CommonRecViewImage;
    private String CommonRecViewType;

    public CommonRecycleViewItem(String name, @DrawableRes int image, String type) {
        this.CommonRecViewName = name;
        this.CommonRecViewImage = image;
        this.CommonRecViewType = type;
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

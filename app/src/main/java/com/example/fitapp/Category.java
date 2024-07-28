package com.example.fitapp;

import androidx.annotation.NonNull;

public class Category {

    private String name;
    private boolean selected;

    public Category(String name){
        this.name = name;
    }

    public boolean isSelected(){
        return selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Category{" +
                "Name='" + name + '\'' +
                '}';
    }
}

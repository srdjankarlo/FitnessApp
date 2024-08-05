package com.example.fitapp;

import androidx.annotation.NonNull;

public class Category {

    private String name;
    private String fromAdapter;

    private boolean selected;

    public Category(String name, String fromAdapter){
        this.name = name;
        this.fromAdapter = fromAdapter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFromAdapter() {
        return fromAdapter;
    }

    public void setFromAdapter(String fromAdapter) {
        this.fromAdapter = fromAdapter;
    }

    public boolean isSelected(){
        return selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    @NonNull
    @Override
    public String toString() {
        return "Category{" +
                "Name='" + name + '\'' +
                "Selected='" + selected + '\'' +
                '}';
    }
}

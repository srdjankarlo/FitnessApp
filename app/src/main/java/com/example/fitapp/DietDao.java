package com.example.fitapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DietDao {

    @Insert
    void insert(DietItem dietItem);

    @Query("SELECT * FROM diet_table")
    LiveData<List<DietItem>> getAllDietData();
}

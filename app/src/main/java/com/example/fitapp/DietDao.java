package com.example.fitapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DietDao {

    @Insert
    void insert(DietItem dietItem);

    @Query("SELECT * FROM diet_table ORDER BY date DESC")
    LiveData<List<DietItem>> getAllDietData();

    @Delete
    void delete(DietItem dietItem);

    @Update
    void update(DietItem dietItem);
}

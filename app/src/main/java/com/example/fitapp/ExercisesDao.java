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
public interface ExercisesDao {

    @Insert
    void insert(ExercisesItem exercisesItem);

    @Query("SELECT * FROM exercises_table")
    LiveData<List<ExercisesItem>> getAllExercisesData();

    @Delete
    void delete(ExercisesItem exercisesItem);

    @Update
    void update(ExercisesItem exercisesItem);

}

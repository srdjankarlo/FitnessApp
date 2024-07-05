package com.example.fitapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ExercisesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ExercisesItem exercisesItem);

    @Query("SELECT * FROM exercises_table")
    LiveData<List<ExercisesItem>> getAllExercisesData();

    @Query("SELECT COUNT(*) FROM exercises_table")
    int getCount();

    @Delete
    void delete(ExercisesItem exercisesItem);

    @Update
    void update(ExercisesItem exercisesItem);

    //@Query("SELECT * FROM exercises_table WHERE :category IN (categories)")
    //LiveData<List<ExercisesItem>> getExercisesByCategory(String category);
    //
    //@Query("SELECT COUNT(*) FROM exercises_table WHERE categories LIKE '%' || :value || '%'")
    //int countInCategory(String value);
}

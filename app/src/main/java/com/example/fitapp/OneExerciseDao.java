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
public interface OneExerciseDao {

    @Insert
    void insert(OneExerciseItem oneExerciseItem);

    @Query("SELECT * FROM one_exercise_table WHERE exerciseName = :exerciseName")
    LiveData<List<OneExerciseItem>> getAllOneExerciseData(String exerciseName);

    @Delete
    void delete(OneExerciseItem oneExerciseItem);

    @Update
    void update(OneExerciseItem oneExerciseItem);

}

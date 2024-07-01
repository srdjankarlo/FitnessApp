package com.example.fitapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class ExercisesViewModel extends AndroidViewModel {
    private ExercisesRepository exercisesRepository;
    private LiveData<List<ExercisesItem>> allExercisesData;

    public ExercisesViewModel(@NonNull Application application){
        super(application);
        exercisesRepository = new ExercisesRepository(application);
        allExercisesData = exercisesRepository.getAllExercisesData();
    }

    public void insert(ExercisesItem exercisesItem){
        exercisesRepository.insertExercisesData(exercisesItem);
    }

    public void delete(ExercisesItem exercisesItem){exercisesRepository.deleteExercisesData(exercisesItem);}

    public void update(ExercisesItem exercisesItem){exercisesRepository.updateExercisesData(exercisesItem);}

    public LiveData<List<ExercisesItem>> getAllExercisesData(){
        return allExercisesData;
    }
}

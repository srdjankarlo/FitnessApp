package com.example.fitapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class OneExerciseViewModel extends AndroidViewModel {
    private OneExerciseRepository oneExercisesRepository;
    private LiveData<List<OneExerciseItem>> allOneExerciseData;

    public OneExerciseViewModel(@NonNull Application application){
        super(application);
        oneExercisesRepository = new OneExerciseRepository(application);
    }

    public void insert(OneExerciseItem oneExerciseItem){
        oneExercisesRepository.insertOneExerciseData(oneExerciseItem);
    }

    public void delete(OneExerciseItem oneExerciseItem){oneExercisesRepository.deleteOneExerciseData(oneExerciseItem);}

    public void update(OneExerciseItem oneExerciseItem){oneExercisesRepository.updateOneExerciseData(oneExerciseItem);}

    public LiveData<List<OneExerciseItem>> getAllOneExerciseData(String exerciseName){
        allOneExerciseData = oneExercisesRepository.getAllOneExerciseData(exerciseName);
        return allOneExerciseData;
    }
}

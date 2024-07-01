package com.example.fitapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class ExercisesRepository {
    private ExercisesDao exercisesDao;
    private LiveData<List<ExercisesItem>> allExercisesData;

    public ExercisesRepository(Application application){
        FitAppDatabase database = FitAppDatabase.getInstance(application);
        exercisesDao = database.exercisesDao();
        allExercisesData = exercisesDao.getAllExercisesData();
    }

    public void insertExercisesData(ExercisesItem exercisesItem){
        new InsertExercisesAsyncTask(exercisesDao).execute(exercisesItem);
    }

    public void deleteExercisesData(ExercisesItem exercisesItem){
        new DeleteExercisesAsyncTask(exercisesDao).execute(exercisesItem);
    }

    public void updateExercisesData(ExercisesItem exercisesItem){
        new UpdateExercisesAsyncTask(exercisesDao).execute(exercisesItem);
    }

    public LiveData<List<ExercisesItem>> getAllExercisesData() {
        return allExercisesData;
    }

    private static class InsertExercisesAsyncTask extends AsyncTask<ExercisesItem, Void, Void>{
        private ExercisesDao exercisesDao;

        private InsertExercisesAsyncTask(ExercisesDao exercisesDao){
            this.exercisesDao = exercisesDao;
        }

        @Override
        protected Void doInBackground(ExercisesItem... exercisesItems){
            exercisesDao.insert(exercisesItems[0]);
            return null;
        }
    }

    private static class DeleteExercisesAsyncTask extends AsyncTask<ExercisesItem, Void, Void>{
        private ExercisesDao exercisesDao;

        private DeleteExercisesAsyncTask(ExercisesDao exercisesDao){
            this.exercisesDao = exercisesDao;
        }

        @Override
        protected Void doInBackground(ExercisesItem... exercisesItems){
            exercisesDao.delete(exercisesItems[0]);
            return null;
        }
    }

    private static class UpdateExercisesAsyncTask extends AsyncTask<ExercisesItem, Void, Void> {
        private ExercisesDao exercisesDao;

        private UpdateExercisesAsyncTask(ExercisesDao exercisesDao) {
            this.exercisesDao = exercisesDao;
        }

        @Override
        protected Void doInBackground(ExercisesItem... exercisesItems) {
            exercisesDao.update(exercisesItems[0]);
            return null;
        }
    }
}

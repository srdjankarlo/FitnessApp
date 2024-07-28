package com.example.fitapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class OneExerciseRepository {
    private OneExerciseDao oneExerciseDao;
    private LiveData<List<OneExerciseItem>> allOneExerciseData;

    public OneExerciseRepository(Application application){
        FitAppDatabase database = FitAppDatabase.getInstance(application);
        oneExerciseDao = database.oneExerciseDao();
    }

    public void insertOneExerciseData(OneExerciseItem oneExerciseItem){
        new OneExerciseRepository.InsertOneExerciseAsyncTask(oneExerciseDao).execute(oneExerciseItem);
    }

    public void deleteOneExerciseData(OneExerciseItem oneExerciseItem){
        new OneExerciseRepository.DeleteOneExerciseAsyncTask(oneExerciseDao).execute(oneExerciseItem);
    }

    public void updateOneExerciseData(OneExerciseItem oneExerciseItem){
        new OneExerciseRepository.UpdateOneExerciseAsyncTask(oneExerciseDao).execute(oneExerciseItem);
    }

    public LiveData<List<OneExerciseItem>> getAllOneExerciseData(String exerciseName) {
        return oneExerciseDao.getAllOneExerciseData(exerciseName);
    }

    private static class InsertOneExerciseAsyncTask extends AsyncTask<OneExerciseItem, Void, Void>{
        private OneExerciseDao oneExerciseDao;

        private InsertOneExerciseAsyncTask(OneExerciseDao oneExerciseDao){
            this.oneExerciseDao = oneExerciseDao;
        }

        @Override
        protected Void doInBackground(OneExerciseItem... oneExerciseItems){
            oneExerciseDao.insert(oneExerciseItems[0]);
            return null;
        }
    }

    private static class DeleteOneExerciseAsyncTask extends AsyncTask<OneExerciseItem, Void, Void>{
        private OneExerciseDao oneExerciseDao;

        private DeleteOneExerciseAsyncTask(OneExerciseDao oneExerciseDao){
            this.oneExerciseDao = oneExerciseDao;
        }

        @Override
        protected Void doInBackground(OneExerciseItem... oneExerciseItems){
            oneExerciseDao.delete(oneExerciseItems[0]);
            return null;
        }
    }

    private static class UpdateOneExerciseAsyncTask extends AsyncTask<OneExerciseItem, Void, Void> {
        private OneExerciseDao oneExerciseDao;

        private UpdateOneExerciseAsyncTask(OneExerciseDao oneExerciseDao) {
            this.oneExerciseDao = oneExerciseDao;
        }

        @Override
        protected Void doInBackground(OneExerciseItem... oneExerciseItems) {
            oneExerciseDao.update(oneExerciseItems[0]);
            return null;
        }
    }
}

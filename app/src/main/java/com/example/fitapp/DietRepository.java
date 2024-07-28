package com.example.fitapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class DietRepository {
    private DietDao dietDao;
    private LiveData<List<DietItem>> allDietData;
    private final FitAppDatabase database;

    public DietRepository(Application application){
        database = FitAppDatabase.getInstance(application);
        dietDao = database.dietDao();
        allDietData = dietDao.getAllDietData();
    }

    public void insertDietData(DietItem dietItem){
        new InsertDietAsyncTask(dietDao).execute(dietItem);
    }

    public void deleteDietData(DietItem dietItem){
        new DeleteDietAsyncTask(dietDao, database).execute(dietItem);
    }

    public void updateDietData(DietItem dietItem){
        new UpdateDietAsyncTask(dietDao).execute(dietItem);
    }

    public LiveData<List<DietItem>> getAllDietData() {
        return allDietData;
    }

    private static class InsertDietAsyncTask extends AsyncTask<DietItem, Void, Void>{
        private DietDao dietDao;

        private InsertDietAsyncTask(DietDao dietDao){
            this.dietDao = dietDao;
        }

        @Override
        protected Void doInBackground(DietItem... dietItems){
            dietDao.insert(dietItems[0]);
            return null;
        }
    }

    private static class DeleteDietAsyncTask extends AsyncTask<DietItem, Void, Void>{
        private DietDao dietDao;
        private final FitAppDatabase db;

        private DeleteDietAsyncTask(DietDao dietDao, FitAppDatabase database){
            this.dietDao = dietDao;
            this.db = database;
        }

        @Override
        protected Void doInBackground(DietItem... dietItems){
            dietDao.delete(dietItems[0]);
            db.vacuum();
            return null;
        }
    }

    private static class UpdateDietAsyncTask extends AsyncTask<DietItem, Void, Void> {
        private DietDao dietDao;

        private UpdateDietAsyncTask(DietDao dietDao) {
            this.dietDao = dietDao;
        }

        @Override
        protected Void doInBackground(DietItem... dietItems) {
            dietDao.update(dietItems[0]);
            return null;
        }
    }
}

package com.example.fitapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//@Database(entities = {DietItem.class, OtherItem.class}, version = 1)
@Database(entities = {DietItem.class}, version = 1)
public abstract class FitAppDatabase extends RoomDatabase {
    private static FitAppDatabase instance;

    public abstract DietDao dietDao();
    //public abstract OtherItemDao otherItemDao();  // for when new item for database is made

    public static synchronized FitAppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), FitAppDatabase.class,
                    "fitapp_database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}

package com.example.fitapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class DietViewModel extends AndroidViewModel {
    private DietRepository dietRepository;
    private LiveData<List<DietItem>> allDietData;

    public DietViewModel(@NonNull Application application){
        super(application);
        dietRepository = new DietRepository(application);
        allDietData = dietRepository.getAllDietData();
    }

    public void insert(DietItem dietItem){
        dietRepository.insertDietData(dietItem);
    }

    public void delete(DietItem dietItem){dietRepository.deleteDietData(dietItem);}

    public void update(DietItem dietItem){dietRepository.updateDietData(dietItem);}

    public LiveData<List<DietItem>> getAllDietData(){
        return allDietData;
    }
}

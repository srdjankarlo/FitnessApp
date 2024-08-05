package com.example.fitapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExercisesRepository {
    private final ExercisesDao exercisesDao;
    private final LiveData<List<ExercisesItem>> allExercisesData;
    private final FitAppDatabase database;

    public ExercisesRepository(Application application){
        database = FitAppDatabase.getInstance(application);
        exercisesDao = database.exercisesDao();
        allExercisesData = exercisesDao.getAllExercisesData();
    }

    public void insertExercisesData(ExercisesItem exercisesItem){
        new InsertExercisesAsyncTask(exercisesDao).execute(exercisesItem);
    }

    public void deleteExercisesData(ExercisesItem exercisesItem){
        new DeleteExercisesAsyncTask(exercisesDao, database).execute(exercisesItem);
    }

    public void updateExercisesData(ExercisesItem exercisesItem){
        new UpdateExercisesAsyncTask(exercisesDao).execute(exercisesItem);
    }

    public LiveData<List<ExercisesItem>> getAllExercisesData() {
        return allExercisesData;
    }

    public void insertInitialData(){
        new InsertInitialDataAsyncTask(exercisesDao).execute();
    }

    private static class InsertExercisesAsyncTask extends AsyncTask<ExercisesItem, Void, Void>{
        private final ExercisesDao exercisesDao;

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
        private final ExercisesDao exercisesDao;
        private final FitAppDatabase db;

        private DeleteExercisesAsyncTask(ExercisesDao exercisesDao, FitAppDatabase database){
            this.exercisesDao = exercisesDao;
            this.db = database;
        }

        @Override
        protected Void doInBackground(ExercisesItem... exercisesItems){
            exercisesDao.delete(exercisesItems[0]);
            db.vacuum();
            return null;
        }
    }

    private static class UpdateExercisesAsyncTask extends AsyncTask<ExercisesItem, Void, Void> {
        private final ExercisesDao exercisesDao;

        private UpdateExercisesAsyncTask(ExercisesDao exercisesDao) {
            this.exercisesDao = exercisesDao;
        }

        @Override
        protected Void doInBackground(ExercisesItem... exercisesItems) {
            exercisesDao.update(exercisesItems[0]);
            return null;
        }
    }

    private static class InsertInitialDataAsyncTask extends AsyncTask<Void, Void, Void>{
        private final ExercisesDao exercisesDao;

        private InsertInitialDataAsyncTask(ExercisesDao exercisesDao){
            this.exercisesDao = exercisesDao;
        }

        @Override
        protected Void doInBackground(Void... voids){
            if(exercisesDao.getCount() == 0){
                // ToDo: ADD INITIAL EXERCISES
                /*List<String> categories = new ArrayList<>();
                categories.add("Chest");
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Push-Up", categories));

                categories = new ArrayList<>();
                categories.add("Abs");
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Sit-Up", categories));*/

                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Pull-Ups", Arrays.asList("Back", "Shoulders", "Triceps"), Arrays.asList("Chest", "Biceps", "Abs"), false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Chin-Ups", Arrays.asList("Back", "Triceps", "Biceps"), Arrays.asList("Chest", "Shoulders", "Abs"),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Deadlifts", Arrays.asList("Back", "Glutes", "Quads", "Hamstrings"), Arrays.asList("Shoulders", "Forearms", "Abs", "Calves"), false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Barbell Bent Over Row", Arrays.asList("Back"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Dumbell Bent Over Row", Arrays.asList("Back"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "T-Bar Bent Over Row", Arrays.asList("Back"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Dumbbell Shrugs", Arrays.asList("Back"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Barbell Shrugs", Arrays.asList("Back"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Back Extensions", Arrays.asList("Back"), Collections.emptyList(),false, "", null, "Gym"));

                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Push-Ups", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Close Grip Push-Ups", Arrays.asList("Chest", "Triceps"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Wide Grip Push-Ups", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Decline Push-Ups", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Incline Push-Ups", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Parallel Bar Dips", Arrays.asList("Chest", "Triceps"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Bench Press", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Incline Press", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Decline Press", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Dumbbell Press", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Incline Dumbbell Press", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Decline Dumbbell Press", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Dumbbell Flys", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Incline Dumbbell Flys", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Decline Dumbbell Flys", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Cable Crossover Flys", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Peck Deck Flys", Arrays.asList("Chest"), Collections.emptyList(),false, "", null, "Gym"));

                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Lateral Raises", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Bent-Over Lateral Raise", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Standing Back Presses", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Standing Front Presses", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Sitting Back Presses", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Sitting Front Presses", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Standing Dumbbell Presses", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Sitting Dumbbell Presses", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Upright Rows", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Peck Deck Rear-Delt Flys", Arrays.asList("Shoulders", "Back"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Front Weight Raise", Arrays.asList("Shoulders"), Collections.emptyList(),false, "", null, "Gym"));

                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Push-Downs", Arrays.asList("Triceps"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Cable Push-Downs", Arrays.asList("Triceps"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Reverse Push-Downs", Arrays.asList("Triceps"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Triceps Dips", Arrays.asList("Triceps"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Dumbbell Kickbacks", Arrays.asList("Triceps"), Collections.emptyList(),false, "", null, "Gym"));

                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Synchronized Dumbbell Curls", Arrays.asList("Biceps"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Synchronized Hammer Curls", Arrays.asList("Biceps", "Forearms"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Synchronized Reverse Dumbbell Curls", Arrays.asList("Biceps", "Forearms"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Asynchronous Dumbbell Curls", Arrays.asList("Biceps"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Asynchronous Hammer Curls", Arrays.asList("Biceps", "Forearms"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Asynchronous Reverse Dumbbell Curls", Arrays.asList("Biceps", "Forearms"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Barbell Curls", Arrays.asList("Biceps"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Reverse Barbell Curls", Arrays.asList("Biceps", "Forearms"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "EZ-Bar Curls", Arrays.asList("Biceps"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Reverse EZ-Bar Curls", Arrays.asList("Biceps", "Forearms"), Collections.emptyList(),false, "", null, "Gym"));

                exercisesDao.insert(new ExercisesItem(R.drawable.forearms, "Barbel Wrist Curls", Arrays.asList("Forearms"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.forearms, "Dumbbell Wrist Curls", Arrays.asList("Forearms"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.forearms, "Dumbbell Wrist Twist", Arrays.asList("Forearms"), Collections.emptyList(),false, "", null, "Gym"));

                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Incline Bench Sit-Ups", Arrays.asList("Abs"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Sit-Ups", Arrays.asList("Abs"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Crunches", Arrays.asList("Abs"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Leg Raises", Arrays.asList("Abs"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Hanging Leg Raises", Arrays.asList("Abs"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Parallel Bar Leg Raises", Arrays.asList("Abs"), Collections.emptyList(),false, "", null, "Gym"));

                exercisesDao.insert(new ExercisesItem(R.drawable.glutes, "Good Mornings", Arrays.asList("Glutes", "Hamstrings"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.glutes, "Hip Thrust", Arrays.asList("Glutes", "Hamstrings"), Collections.emptyList(),false, "", null, "Gym"));

                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Leg Extensions", Arrays.asList("Quads"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Squats", Arrays.asList("Quads", "Glutes", "Hamstrings"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Dumbbell Squats", Arrays.asList("Quads", "Glutes"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Barbell Squats", Arrays.asList("Quads", "Glutes"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Lunges", Arrays.asList("Quads"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Dumbbell Lunges", Arrays.asList("Quads"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Barbell Lunges", Arrays.asList("Quads"), Collections.emptyList(),false, "", null, "Gym"));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Bench Jump", Arrays.asList("Quads", "Hamstrings"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Single Leg Squats", Arrays.asList("Quads"), Collections.emptyList(),false, "", null, "Home"));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Open Jump", Arrays.asList("Quads"), Collections.emptyList(),false, "", null, "Home"));

                exercisesDao.insert(new ExercisesItem(R.drawable.hamstrings, "Leg Curls", Arrays.asList("Hamstrings", "Calves"), Collections.emptyList(),false, "", null, "Gym"));
            }
            return null;
        }
    }
}

package com.example.fitapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void insertInitialData(){
        new InsertInitialDataAsyncTask(exercisesDao).execute();
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

    private static class InsertInitialDataAsyncTask extends AsyncTask<Void, Void, Void>{
        private final ExercisesDao exercisesDao;

        private InsertInitialDataAsyncTask(ExercisesDao exercisesDao){
            this.exercisesDao = exercisesDao;
        }

        @Override
        protected Void doInBackground(Void... voids){
            if(exercisesDao.getCount() == 0){
                // ToDo: ADD INITIAL EXERCISES
                //List<String> categories = new ArrayList<>();
                //categories.add("Chest");
                //exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Push-Up", categories));
                //
                //categories = new ArrayList<>();
                //categories.add("Abs");
                //exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Sit-Up", categories));

                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Push-Ups", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Close Grip Push-Ups", Arrays.asList("Chest", "Triceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Wide Grip Push-Ups", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Decline Push-Ups", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Incline Push-Ups", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Parallel Bar Dips", Arrays.asList("Chest", "Triceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Bench Press", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Incline Press", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Decline Press", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Dumbbell Press", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Incline Dumbbell Press", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Decline Dumbbell Press", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Dumbbell Flys", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Incline Dumbbell Flys", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Decline Dumbbell Flys", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Cable Crossover Flys", Arrays.asList("Chest")));
                exercisesDao.insert(new ExercisesItem(R.drawable.chest, "Peck Deck Flys", Arrays.asList("Chest")));

                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Lateral Raises", Arrays.asList("Shoulders")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Bent-Over Lateral Raise", Arrays.asList("Shoulders")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Standing Back Presses", Arrays.asList("Shoulders")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Standing Front Presses", Arrays.asList("Shoulders")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Sitting Back Presses", Arrays.asList("Shoulders")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Sitting Front Presses", Arrays.asList("Shoulders")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Standing Dumbbell Presses", Arrays.asList("Shoulders")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Sitting Dumbbell Presses", Arrays.asList("Shoulders")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Upright Rows", Arrays.asList("Shoulders")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Peck Deck Rear-Delt Flys", Arrays.asList("Shoulders", "Back")));
                exercisesDao.insert(new ExercisesItem(R.drawable.shoulders, "Front Weight Raise", Arrays.asList("Shoulders")));

                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Synchronized Dumbbell Curls", Arrays.asList("Biceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Synchronized Hammer Curls", Arrays.asList("Biceps", "Forearms")));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Synchronized Reverse Dumbbell Curls", Arrays.asList("Biceps", "Forearms")));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Asynchronous Dumbbell Curls", Arrays.asList("Biceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Asynchronous Hammer Curls", Arrays.asList("Biceps", "Forearms")));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Asynchronous Reverse Dumbbell Curls", Arrays.asList("Biceps", "Forearms")));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Barbell Curls", Arrays.asList("Biceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Reverse Barbell Curls", Arrays.asList("Biceps", "Forearms")));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "EZ-Bar Curls", Arrays.asList("Biceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.biceps, "Reverse EZ-Bar Curls", Arrays.asList("Biceps", "Forearms")));

                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Push-Downs", Arrays.asList("Triceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Cable Push-Downs", Arrays.asList("Triceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Reverse Push-Downs", Arrays.asList("Triceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Triceps Dips", Arrays.asList("Triceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.triceps, "Dumbbell Kickbacks", Arrays.asList("Triceps")));

                exercisesDao.insert(new ExercisesItem(R.drawable.forearms, "Barbel Wrist Curls", Arrays.asList("Forearms")));
                exercisesDao.insert(new ExercisesItem(R.drawable.forearms, "Dumbbell Wrist Curls", Arrays.asList("Forearms")));
                exercisesDao.insert(new ExercisesItem(R.drawable.forearms, "Dumbbell Wrist Twist", Arrays.asList("Forearms")));

                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Chin-Ups", Arrays.asList("Back")));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Reverse Chin-Ups", Arrays.asList("Back", "Biceps")));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Deadlifts", Arrays.asList("Back")));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Barbell Bent Over Row", Arrays.asList("Back")));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Dumbell Bent Over Row", Arrays.asList("Back")));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "T-Bar Bent Over Row", Arrays.asList("Back")));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Dumbbell Shrugs", Arrays.asList("Back")));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Barbell Shrugs", Arrays.asList("Back")));
                exercisesDao.insert(new ExercisesItem(R.drawable.back, "Back Extensions", Arrays.asList("Back")));

                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Incline Bench Sit-Ups", Arrays.asList("Abs")));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Sit-Ups", Arrays.asList("Abs")));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Crunches", Arrays.asList("Abs")));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Leg Raises", Arrays.asList("Abs")));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Hanging Leg Raises", Arrays.asList("Abs")));
                exercisesDao.insert(new ExercisesItem(R.drawable.abs, "Parallel Bar Leg Raises", Arrays.asList("Abs")));

                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Leg Extensions", Arrays.asList("Quads")));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Squats", Arrays.asList("Quads", "Glutes")));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Dumbbell Squats", Arrays.asList("Quads", "Glutes")));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Barbell Squats", Arrays.asList("Quads", "Glutes")));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Lunges", Arrays.asList("Quads")));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Dumbbell Lunges", Arrays.asList("Quads")));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Barbell Lunges", Arrays.asList("Quads")));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Bench Jump", Arrays.asList("Quads", "Hamstrings")));
                exercisesDao.insert(new ExercisesItem(R.drawable.glutes, "Good Mornings", Arrays.asList("Glutes", "Hamstrings")));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Single Leg Squats", Arrays.asList("Quads")));
                exercisesDao.insert(new ExercisesItem(R.drawable.quads, "Open Jump", Arrays.asList("Quads")));
                exercisesDao.insert(new ExercisesItem(R.drawable.hamstrings, "Leg Curls", Arrays.asList("Hamstrings", "Calves")));
                exercisesDao.insert(new ExercisesItem(R.drawable.glutes, "Hip Thrust", Arrays.asList("Glutes", "Hamstrings")));
            }
            return null;
        }
    }

    //public LiveData<List<ExercisesItem>> getExercisesByCategory(String category) {
    //    return exercisesDao.getExercisesByCategory(category);
    //}
    //
    //public LiveData<Integer> countInCategory(String value) {
    //    MutableLiveData<Integer> countLiveData = new MutableLiveData<>();
    //    new CountCategoryAsyncTask(exercisesDao, countLiveData).execute(value);
    //    return countLiveData;
    //}
    //
    //private static class CountCategoryAsyncTask extends AsyncTask<String, Void, Integer> {
    //    private final ExercisesDao exercisesDao;
    //    private final MutableLiveData<Integer> countLiveData;
    //
    //    private CountCategoryAsyncTask(ExercisesDao exercisesDao, MutableLiveData<Integer> countLiveData) {
    //        this.exercisesDao = exercisesDao;
    //        this.countLiveData = countLiveData;
    //    }
    //
    //    @Override
    //    protected Integer doInBackground(String... strings) {
    //        return exercisesDao.countInCategory(strings[0]);
    //    }
    //
    //    @Override
    //    protected void onPostExecute(Integer count) {
    //        countLiveData.setValue(count);
    //    }
    //}
}

package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class PopUpDietEdit extends DietActivity_0_1 {

    DietItem dietItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_diet_edit);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout(width, (int) (height*.25));

        // ToDO: see this https://www.youtube.com/watch?v=fn5OlqQuOCk to make see previous activity bellow this one // this doent work

        DietRecViewAdapter adapter = getAdapter();

        // get data from previous activity
        Bundle intent = getIntent().getExtras();
        //int position = intent.getInt("position");
        //dietItem = adapter.getDietAtPosition(position);
        dietItem = intent.getParcelable("dietItem");

    }

    public void Update(View view) {

    }

    public void Delete(View view) {
        dietViewModel.delete(dietItem);
    }
}
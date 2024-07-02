package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DietActivity_0_1 extends AppCompatActivity implements DietInterface {

    protected DietAdapter adapter;
    RecyclerView RecView;
    DietViewModel dietViewModel;
    public int sumProteins = 0, sumFats = 0, sumCarbs = 0, sumCals = 0;
    TextView tvProteins, tvFats, tvCarbs, tvCals;
    String formatedCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set layout
        setContentView(R.layout.activity_diet);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Diet tracker");

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        // get the recycler view in order to manipulate it
        RecView = findViewById(R.id.id_ac_di_RecView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // to show items in reverse
        // layoutManager.setReverseLayout(true);
        // layoutManager.setStackFromEnd(true);

        RecView.setLayoutManager(layoutManager);
        RecView.setHasFixedSize(true);

        // set the adapter for recycler view and show items in it
        adapter = new DietAdapter(this, this);
        //adapter.setItems(item_list); // items are set in adapter in view model
        RecView.setAdapter(adapter);  // To show items in recycler view, attach adapter to it

        long currentTimestamp = System.currentTimeMillis();
        Date currentDate = new Date(currentTimestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        formatedCurrentDate = sdf.format(currentDate);

        dietViewModel = new ViewModelProvider(this).get(DietViewModel.class);
        dietViewModel.getAllDietData().observe(this, new Observer<List<DietItem>>() {
            @Override
            public void onChanged(List<DietItem> dietItems) {
                adapter.setItems(dietItems);
                calculateDailyIntake(dietItems);
            }
        });
    }

    public void AddMeal(View view) {

        long current_date = System.currentTimeMillis();
        EditText edit_name = findViewById(R.id.id_ac_di_EditText1);
        EditText edit_proteins = findViewById(R.id.id_ac_di_EditText2);
        EditText edit_fats = findViewById(R.id.id_ac_di_EditText3);
        EditText edit_carbs = findViewById(R.id.id_ac_di_EditText4);
        EditText edit_calories = findViewById(R.id.id_ac_di_EditText5);

        Editable editable_name = edit_name.getText();
        Editable editable_proteins = edit_proteins.getText();
        Editable editable_fats = edit_fats.getText();
        Editable editable_carbs = edit_carbs.getText();
        Editable editable_calories = edit_calories.getText();

        String name_text = (TextUtils.isEmpty(editable_name.toString())) ? "None" : editable_name.toString();
        int proteins_text = (TextUtils.isEmpty(editable_proteins.toString())) ? 0 : Integer.parseInt(editable_proteins.toString());
        int fats_text = (TextUtils.isEmpty(editable_fats.toString())) ? 0 : Integer.parseInt(editable_fats.toString());
        int carbs_text = (TextUtils.isEmpty(editable_carbs.toString())) ? 0 : Integer.parseInt(editable_carbs.toString());
        int calories_text = (TextUtils.isEmpty(editable_calories.toString())) ? 0 : Integer.parseInt(editable_calories.toString());

        DietItem new_item = new DietItem(current_date, name_text, proteins_text, fats_text, carbs_text, calories_text);
        dietViewModel.insert(new_item);

        edit_name.getText().clear();
        edit_proteins.getText().clear();
        edit_fats.getText().clear();
        edit_carbs.getText().clear();
        edit_calories.getText().clear();
    }

    public void calculateDailyIntake(List<DietItem> dietItems){
        sumProteins = 0;
        sumFats = 0;
        sumCarbs = 0;
        sumCals = 0;

        for(DietItem dietItem : dietItems){
            long item_timestamp = dietItem.getDate();
            Date itemDate = new Date(item_timestamp);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            String formatedItemDate = simpleDateFormat.format(itemDate);
            if(Objects.equals(formatedCurrentDate, formatedItemDate)){
                sumProteins += dietItem.getProteins();
                sumFats += dietItem.getFats();
                sumCarbs += dietItem.getCarbohydrates();
                sumCals += dietItem.getCalories();
            }
        }

        tvProteins = findViewById(R.id.ac_di_TextViewProteins);
        tvFats = findViewById(R.id.ac_di_TextViewFats);
        tvCarbs = findViewById(R.id.ac_di_TextViewCarbs);
        tvCals = findViewById(R.id.ac_di_TextViewCalories);

        tvProteins.setText(String.valueOf(sumProteins) + "g");
        tvFats.setText(String.valueOf(sumFats) + "g");
        tvCarbs.setText(String.valueOf(sumCarbs) + "g");
        tvCals.setText(String.valueOf(sumCals) + "kcal");
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(), PopUpDietEdit.class);
        intent.putExtra("dietItem", adapter.getDietAtPosition(position));
        startActivity(intent);
    }
}
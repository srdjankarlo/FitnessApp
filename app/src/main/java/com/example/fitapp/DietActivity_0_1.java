package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DietActivity_0_1 extends AppCompatActivity implements DietItemInterface {

    List<DietItem> item_list = new ArrayList<>();
    //DietRecViewAdapter adapter = new DietRecViewAdapter(this, this);
    protected DietRecViewAdapter adapter;
    RecyclerView RecView;
    DietViewModel dietViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get data from previous activity
        //Intent intent = getIntent();
        //item_list = intent.getParcelableArrayListExtra("RecViewItemsList");

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
        //layoutManager.setReverseLayout(true);
        //layoutManager.setStackFromEnd(true);

        RecView.setLayoutManager(layoutManager);
        RecView.setHasFixedSize(true);

        // set the adapter for recycler view and show items in it
        adapter = new DietRecViewAdapter(this, this);
        adapter.setItems(item_list);
        RecView.setAdapter(adapter);

        dietViewModel = new ViewModelProvider(this).get(DietViewModel.class);
        dietViewModel.getAllDietData().observe(this, new Observer<List<DietItem>>() {
            @Override
            public void onChanged(List<DietItem> dietItems) {
                adapter.setItems(dietItems);
            }
        });
    }

    public DietRecViewAdapter getAdapter(){
        return adapter;
    }

    // what to do when ADD MEAL button is pressed
    public void AddMeal(View view) {

        long current_date = System.currentTimeMillis();
        EditText edit_name = findViewById(R.id.id_ac_di_EditText1);
        EditText edit_proteins = findViewById(R.id.id_ac_di_EditText2);
        EditText edit_fats = findViewById(R.id.id_ac_di_EditText3);
        EditText edit_carbs = findViewById(R.id.id_ac_di_EditText4);
        EditText edit_sugars = findViewById(R.id.id_ac_di_EditText5);

        Editable editable_name = edit_name.getText();
        Editable editable_proteins = edit_proteins.getText();
        Editable editable_fats = edit_fats.getText();
        Editable editable_carbs = edit_carbs.getText();
        Editable editable_sugars = edit_sugars.getText();

        String name_text = (TextUtils.isEmpty(editable_name.toString())) ? "None" : editable_name.toString();
        int proteins_text = (TextUtils.isEmpty(editable_proteins.toString())) ? 0 : Integer.parseInt(editable_proteins.toString());
        int fats_text = (TextUtils.isEmpty(editable_fats.toString())) ? 0 : Integer.parseInt(editable_fats.toString());
        int carbs_text = (TextUtils.isEmpty(editable_carbs.toString())) ? 0 : Integer.parseInt(editable_carbs.toString());
        int sugars_text = (TextUtils.isEmpty(editable_sugars.toString())) ? 0 : Integer.parseInt(editable_sugars.toString());

        // ToDo: make a date field, to be the same as the type of date field used in one exercise
        DietItem new_item = new DietItem(current_date, name_text, proteins_text, fats_text, carbs_text, sugars_text);
        dietViewModel.insert(new_item);

        edit_name.getText().clear();
        edit_proteins.getText().clear();
        edit_fats.getText().clear();
        edit_carbs.getText().clear();
        edit_sugars.getText().clear();
    }

    @Override
    public void onItemClick(int position) {
        // ToDo: logic to delete or update diet item

        //Toast.makeText(DietActivity_0_1.this, "Item clicked", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), PopUpDietEdit.class);
        //intent.putExtra("position", position);
        intent.putExtra("dietItem", adapter.getDietAtPosition(position));
        startActivity(intent);
        //startActivity(new Intent(DietActivity_0_1.this, PopUpDietEdit.class));
    }
}
package com.example.fitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class DietActivity_0_1 extends AppCompatActivity {

    ArrayList<DietItem> item_list = new ArrayList<>();
    DietRecViewAdapter adapter = new DietRecViewAdapter(this);
    RecyclerView RecView;

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

        // set the adapter for recycler view and show items in it
        //MainMenuRecViewAdapter adapter = new MainMenuRecViewAdapter(this, this);
        adapter.setItems(item_list);
        RecView.setAdapter(adapter);

        // to show items in reverse
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        RecView.setLayoutManager(layoutManager);

    }

    // what to do when ADD MEAL button is pressed
    public void AddMeal(View view) {

        Date current_date = new Date();
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

        //String name_text = editable_name.toString();
        //int proteins_text = Integer.parseInt(editable_proteins.toString());
        //int fats_text = Integer.parseInt(editable_fats.toString());
        //int carbs_text = Integer.parseInt(editable_carbs.toString());
        //int sugars_text = Integer.parseInt(editable_sugars.toString());

        //String name_text = (editable_name.toString().equals("")) ? "-" : editable_name.toString();
        //String proteins_text = (editable_proteins.toString().equals("")) ? "-" : editable_proteins.toString();
        //String fats_text = (editable_fats.toString().equals("")) ? "-" : editable_fats.toString();
        //String carbs_text = (editable_carbs.toString().equals("")) ? "-" : editable_carbs.toString();
        //String sugars_text = (editable_sugars.toString().equals("")) ? "-" : editable_sugars.toString();

        // ToDo: make a date field, to be the same as the type of date field used in one exercise
        DietItem new_item = new DietItem(current_date, name_text, proteins_text, fats_text, carbs_text, sugars_text);

        // add item to adapter and scroll to last item (in this case first item bcs we reversed recyclerview)
        adapter.addItem(new_item);
        RecView.smoothScrollToPosition(adapter.getItemCount() - 1);

        edit_name.getText().clear();
        edit_proteins.getText().clear();
        edit_fats.getText().clear();
        edit_carbs.getText().clear();
        edit_sugars.getText().clear();
    }
}
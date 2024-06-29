package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PopUpDietEdit extends DietActivity_0_1 {

    DietItem dietItem;
    EditText edit_name;
    EditText edit_proteins;
    EditText edit_fats;
    EditText edit_carbs;
    EditText edit_sugars;

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

        long date = dietItem.getDate();
        String food_name = dietItem.getFood_name();
        int proteins = dietItem.getProteins();
        int fats = dietItem.getFats();
        int carbs = dietItem.getCarbohydrates();
        int sugars = dietItem.getSugars();

        TextView date2 = findViewById(R.id.ac_po_up_di_TextView0);
        date2.setText(String.valueOf(date));  // ToDo: this writes timestamp and not formated date

        edit_name = findViewById(R.id.ac_po_up_di_EditText1);
        edit_name.setText(food_name);

        edit_proteins = findViewById(R.id.ac_po_up_di_EditText2);
        edit_proteins.setText(String.valueOf(proteins));

        edit_fats = findViewById(R.id.ac_po_up_di_EditText3);
        edit_fats.setText(String.valueOf(fats));

        edit_carbs = findViewById(R.id.ac_po_up_di_EditText4);
        edit_carbs.setText(String.valueOf(carbs));

        edit_sugars = findViewById(R.id.ac_po_up_di_EditText5);
        edit_sugars.setText(String.valueOf(sugars));
    }

    public void Update(View view) {
        // ToDo: make to work update
        EditText edit_name = findViewById(R.id.ac_po_up_di_EditText1);
        EditText edit_proteins = findViewById(R.id.ac_po_up_di_EditText2);
        EditText edit_fats = findViewById(R.id.ac_po_up_di_EditText3);
        EditText edit_carbs = findViewById(R.id.ac_po_up_di_EditText4);
        EditText edit_sugars = findViewById(R.id.ac_po_up_di_EditText5);

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

        dietItem.setFood_name(name_text);
        dietItem.setProteins(proteins_text);
        dietItem.setFats(fats_text);
        dietItem.setCarbohydrates(carbs_text);
        dietItem.setSugars(sugars_text);
        
        dietViewModel.update(dietItem);

        finish();
    }

    public void Delete(View view) {
        dietViewModel.delete(dietItem);
        finish();
    }
}
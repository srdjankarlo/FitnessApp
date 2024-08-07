package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;

public class DietActivity_0_1 extends AppCompatActivity implements DietInterface {

    protected DietAdapter adapter;
    RecyclerView RecView;
    DietViewModel dietViewModel;
    public int sumProteins = 0, sumFats = 0, sumCarbs = 0, sumCals = 0;
    TextView tvProteins, tvFats, tvCarbs, tvCals;
    String formatedCurrentDate;
    //GraphView plot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // change app bar title
        Objects.requireNonNull(getSupportActionBar()).setTitle("Diet tracker");

        // change app bar color
        ActionBar bar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#757575"));  // gray light
        bar.setBackgroundDrawable(color);

        setTrackerData();
    }

    public void AddMeal(View view) {

        long current_date = System.currentTimeMillis();
        EditText edit_name = findViewById(R.id.ac_di_EditTextFoodName);
        EditText edit_own_weight = findViewById(R.id.ac_di_EditTextOwnWeight);
        EditText edit_proteins = findViewById(R.id.ac_di_EditTextProteins);
        EditText edit_fats = findViewById(R.id.ac_di_EditTextFats);
        EditText edit_carbs = findViewById(R.id.ac_di_EditTextCarbs);
        EditText edit_calories = findViewById(R.id.ac_di_EditTextCals);

        Editable editable_name = edit_name.getText();
        Editable editable_ow = edit_own_weight.getText();
        Editable editable_proteins = edit_proteins.getText();
        Editable editable_fats = edit_fats.getText();
        Editable editable_carbs = edit_carbs.getText();
        Editable editable_calories = edit_calories.getText();

        String name_text = (TextUtils.isEmpty(editable_name.toString())) ? "None" : editable_name.toString();
        int ow_text = (TextUtils.isEmpty(editable_ow.toString())) ? 0 : Integer.parseInt(editable_ow.toString());
        int proteins_text = (TextUtils.isEmpty(editable_proteins.toString())) ? 0 : Integer.parseInt(editable_proteins.toString());
        int fats_text = (TextUtils.isEmpty(editable_fats.toString())) ? 0 : Integer.parseInt(editable_fats.toString());
        int carbs_text = (TextUtils.isEmpty(editable_carbs.toString())) ? 0 : Integer.parseInt(editable_carbs.toString());
        int calories_text = (TextUtils.isEmpty(editable_calories.toString())) ? 0 : Integer.parseInt(editable_calories.toString());

        DietItem new_item = new DietItem(current_date, name_text, ow_text, proteins_text, fats_text, carbs_text, calories_text);
        dietViewModel.insert(new_item);

        edit_name.getText().clear();
        edit_own_weight.getText().clear();
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

        if(tvProteins != null && tvFats != null && tvCarbs != null && tvCals != null) {
            tvProteins.setText(sumProteins + "g");
            tvFats.setText(sumFats + "g");
            tvCarbs.setText(sumCarbs + "g");
            tvCals.setText(sumCals + "kcal");
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(), PopUpDietEdit.class);
        intent.putExtra("dietItem", adapter.getDietAtPosition(position));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.diet_menu, menu);
        return true;
    }

    public void setTrackerData(){
        // set layout
        setContentView(R.layout.activity_diet);

        // get the recycler view in order to manipulate it
        RecView = findViewById(R.id.id_ac_di_RecView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        // get the id of clicked menu item
        int menu_id = item.getItemId();
        if (menu_id == R.id.di_me_item1) {
            setTrackerData();
        } else if (menu_id == R.id.di_me_item2) {
            // set layout
            setContentView(R.layout.diet_chart);
            // ToDo: https://www.youtube.com/watch?v=Lnm6YG8Ub50 use this instead of current graph
            LineChart plot1 = findViewById(R.id.di_ch_plot1);
            //plot1.getDescription().setEnabled(false);
            plot1.getDescription().setText("Values in kg");
            LineChart plot2 = findViewById(R.id.di_ch_plot2);
            //plot2.getDescription().setEnabled(false);
            plot2.getDescription().setText("Values in grams");
            LineChart plot3 = findViewById(R.id.di_ch_plot3);
            //plot1.getDescription().setEnabled(false);
            plot3.getDescription().setText("Values in kcal");

            dietViewModel.getAllDietData().observe(this, new Observer<List<DietItem>>() {
                @Override
                public void onChanged(List<DietItem> dietItems) {
                    List<Long> dates = new ArrayList<>();
                    List<Integer> weights = new ArrayList<>();
                    List<Integer> proteins = new ArrayList<>();
                    List<Integer> fats = new ArrayList<>();
                    List<Integer> carbs = new ArrayList<>();
                    List<Integer> cals = new ArrayList<>();

                    // Extract dates and weights from dietItems
                    for (DietItem item : dietItems) {
                        dates.add(item.getDate());
                        weights.add(item.getOwn_weight());
                        proteins.add(item.getProteins());
                        fats.add(item.getFats());
                        carbs.add(item.getCarbohydrates());
                        cals.add(item.getCalories());
                    }

                    // Reverse the lists
                    Collections.reverse(dates);
                    Collections.reverse(weights);
                    Collections.reverse(proteins);
                    Collections.reverse(fats);
                    Collections.reverse(carbs);
                    Collections.reverse(cals);

                    if (!dates.isEmpty() && !weights.isEmpty()) {

                        List<Entry> entries1 = new ArrayList<>();
                        List<Entry> entries2_1 = new ArrayList<>();
                        List<Entry> entries2_2 = new ArrayList<>();
                        List<Entry> entries2_3 = new ArrayList<>();
                        List<Entry> entries3 = new ArrayList<>();
                        for (int i = 0; i < weights.size(); i++) {
                            entries1.add(new Entry(i, weights.get(i)));
                            entries2_1.add(new Entry(i, proteins.get(i)));
                            entries2_2.add(new Entry(i, fats.get(i)));
                            entries2_3.add(new Entry(i, carbs.get(i)));
                            entries3.add(new Entry(i, cals.get(i)));
                        }

                        LineDataSet dataSet1 = new LineDataSet(entries1, "Weight");
                        LineData lineData1 = new LineData(dataSet1);
                        plot1.setData(lineData1);

                        LineDataSet dataSet2_1 = new LineDataSet(entries2_1, "Proteins");
                        dataSet2_1.setColor(Color.RED);
                        dataSet2_1.setLineWidth(2f);
                        dataSet2_1.setValueTextColor(Color.RED);

                        LineDataSet dataSet2_2 = new LineDataSet(entries2_2, "Fats");
                        dataSet2_2.setColor(Color.BLUE);
                        dataSet2_2.setLineWidth(2f);
                        dataSet2_2.setValueTextColor(Color.BLUE);

                        LineDataSet dataSet2_3 = new LineDataSet(entries2_3, "Carbs");
                        dataSet2_3.setColor(Color.GREEN);
                        dataSet2_3.setLineWidth(2f);
                        dataSet2_3.setValueTextColor(Color.GREEN);

                        LineDataSet dataSet3 = new LineDataSet(entries3, "Calories");
                        dataSet3.setColor(Color.YELLOW);
                        dataSet3.setLineWidth(2f);
                        dataSet3.setValueTextColor(Color.YELLOW);

                        LineData lineData2 = new LineData(dataSet2_1, dataSet2_2, dataSet2_3);
                        plot2.setData(lineData2);

                        LineData lineData3 = new LineData(dataSet3);
                        plot3.setData(lineData3);

                        XAxis xAxis1 = plot1.getXAxis();
                        xAxis1.setValueFormatter(new DateValueFormatter(dates));
                        xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);
                        xAxis1.setGranularity(1f);
                        xAxis1.setGranularityEnabled(true);
                        // visible labels for "different" x axis labels, if in one day is 10 entries than all 10 will be showed because they are on the same day
                        //xAxis.setLabelCount(5, true);

                        XAxis xAxis2 = plot2.getXAxis();
                        xAxis2.setValueFormatter(new DateValueFormatter(dates));
                        xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
                        xAxis2.setGranularity(1f);
                        xAxis2.setGranularityEnabled(true);

                        XAxis xAxis3 = plot3.getXAxis();
                        xAxis3.setValueFormatter(new DateValueFormatter(dates));
                        xAxis3.setPosition(XAxis.XAxisPosition.BOTTOM);
                        xAxis3.setGranularity(1f);
                        xAxis3.setGranularityEnabled(true);

                        // set number of visible labels for y axis
                        YAxis yAxis1 = plot1.getAxisLeft();
                        yAxis1.setLabelCount(5, true); // number of visible labels
                        // Disable right y-axis
                        plot1.getAxisRight().setEnabled(false);

                        YAxis yAxis2 = plot2.getAxisLeft();
                        yAxis2.setLabelCount(5, true);
                        plot2.getAxisRight().setEnabled(false);

                        YAxis yAxis3 = plot3.getAxisLeft();
                        yAxis3.setLabelCount(5, true);
                        plot3.getAxisRight().setEnabled(false);

                        // Enable scaling and dragging
                        plot1.setDragEnabled(true);
                        plot1.setScaleEnabled(true);
                        plot1.setPinchZoom(true);

                        plot2.setDragEnabled(true);
                        plot2.setScaleEnabled(true);
                        plot2.setPinchZoom(true);

                        plot3.setDragEnabled(true);
                        plot3.setScaleEnabled(true);
                        plot3.setPinchZoom(true);

                        // Set the visible range
                        if (entries1.size() > 5) {
                            plot1.setVisibleXRangeMaximum(5);
                            plot1.moveViewToX(entries1.size() - 5);

                            plot2.setVisibleXRangeMaximum(5);
                            plot2.moveViewToX(entries1.size() - 5);

                            plot3.setVisibleXRangeMaximum(5);
                            plot3.moveViewToX(entries1.size() - 5);
                        }

                        plot1.invalidate(); // Refresh the chart
                        plot2.invalidate();
                        plot3.invalidate();

                        // Synchronize scrolling
                        synchronizeCharts(plot1, plot2, plot3);
                    }
                }
            });
        }

        return true;
    }

    private void synchronizeCharts(LineChart chart1, LineChart chart2, LineChart chart3) {
        chart1.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                chart2.setOnChartGestureListener(null); // temporarily remove listener
                chart3.setOnChartGestureListener(null); // temporarily remove listener
            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                synchronizeCharts(chart1, chart2, chart3); // re-add listener
            }

            @Override
            public void onChartLongPressed(MotionEvent me) {}

            @Override
            public void onChartDoubleTapped(MotionEvent me) {}

            @Override
            public void onChartSingleTapped(MotionEvent me) {}

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {}

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
                chart2.getViewPortHandler().refresh(chart1.getViewPortHandler().getMatrixTouch(), chart2, true);
                chart3.getViewPortHandler().refresh(chart1.getViewPortHandler().getMatrixTouch(), chart3, true);
            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                chart2.getViewPortHandler().refresh(chart1.getViewPortHandler().getMatrixTouch(), chart2, true);
                chart3.getViewPortHandler().refresh(chart1.getViewPortHandler().getMatrixTouch(), chart3, true);
            }
        });

        chart2.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                chart1.setOnChartGestureListener(null); // temporarily remove listener
                chart3.setOnChartGestureListener(null); // temporarily remove listener
            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                synchronizeCharts(chart1, chart2, chart3); // re-add listener
            }

            @Override
            public void onChartLongPressed(MotionEvent me) {}

            @Override
            public void onChartDoubleTapped(MotionEvent me) {}

            @Override
            public void onChartSingleTapped(MotionEvent me) {}

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {}

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
                chart1.getViewPortHandler().refresh(chart2.getViewPortHandler().getMatrixTouch(), chart1, true);
                chart3.getViewPortHandler().refresh(chart2.getViewPortHandler().getMatrixTouch(), chart3, true);
            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                chart1.getViewPortHandler().refresh(chart2.getViewPortHandler().getMatrixTouch(), chart1, true);
                chart3.getViewPortHandler().refresh(chart2.getViewPortHandler().getMatrixTouch(), chart3, true);
            }
        });

        chart3.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                chart1.setOnChartGestureListener(null); // temporarily remove listener
                chart2.setOnChartGestureListener(null); // temporarily remove listener
            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                synchronizeCharts(chart1, chart2, chart3); // re-add listener
            }

            @Override
            public void onChartLongPressed(MotionEvent me) {}

            @Override
            public void onChartDoubleTapped(MotionEvent me) {}

            @Override
            public void onChartSingleTapped(MotionEvent me) {}

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {}

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
                chart1.getViewPortHandler().refresh(chart3.getViewPortHandler().getMatrixTouch(), chart1, true);
                chart2.getViewPortHandler().refresh(chart3.getViewPortHandler().getMatrixTouch(), chart2, true);
            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                chart1.getViewPortHandler().refresh(chart3.getViewPortHandler().getMatrixTouch(), chart1, true);
                chart2.getViewPortHandler().refresh(chart3.getViewPortHandler().getMatrixTouch(), chart2, true);
            }
        });
    }

    /*private void synchronizeCharts(LineChart chart1, LineChart chart2) {
        chart1.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                chart2.setOnChartGestureListener(null); // temporarily remove listener
            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                synchronizeCharts(chart1, chart2); // re-add listener
            }

            @Override
            public void onChartLongPressed(MotionEvent me) {}

            @Override
            public void onChartDoubleTapped(MotionEvent me) {}

            @Override
            public void onChartSingleTapped(MotionEvent me) {}

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {}

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
                chart2.getViewPortHandler().refresh(chart1.getViewPortHandler().getMatrixTouch(), chart2, true);
            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                chart2.getViewPortHandler().refresh(chart1.getViewPortHandler().getMatrixTouch(), chart2, true);
            }
        });

        chart2.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                chart1.setOnChartGestureListener(null); // temporarily remove listener
            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                synchronizeCharts(chart1, chart2); // re-add listener
            }

            @Override
            public void onChartLongPressed(MotionEvent me) {}

            @Override
            public void onChartDoubleTapped(MotionEvent me) {}

            @Override
            public void onChartSingleTapped(MotionEvent me) {}

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {}

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
                chart1.getViewPortHandler().refresh(chart2.getViewPortHandler().getMatrixTouch(), chart1, true);
            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                chart1.getViewPortHandler().refresh(chart2.getViewPortHandler().getMatrixTouch(), chart1, true);
            }
        });
    }*/

}
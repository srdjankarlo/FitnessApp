package com.example.fitapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChExRecViewAdapter extends RecyclerView.Adapter<ChExRecViewAdapter.ViewHolder> {

    private ArrayList<ChestExercise> chest_exercises = new ArrayList<>();

    private Context context;

    public ChExRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chest_exercises_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id_ch_ex_it_TextView.setText(chest_exercises.get(position).getNameChestExercise());
        holder.id_ch_ex_it_ImageView.setImageResource(chest_exercises.get(position).getImageChestExercise());
        holder.ch_ex_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context, muscle_groups.get(holder.getAdapterPosition()).getNameMuscleGroup() + " selected", Toast.LENGTH_SHORT).show();

                // to make switch to correct muscle group layout/activity [0: Chest, 1: Shoulders, 2: Biceps, ...]]
                final Intent intent;

                // ToDo: make chest recycler view adapter and layout and try passing it as intent
                // in order to not create more activities cuz we need to set code for menu bar again
                // and that would be much unnecessary lines of code
                // see if back button will work

                /*
                if(holder.getAdapterPosition() == 0){
                    intent = new Intent(context, ChestExercisesActivity.class);
                } else if (holder.getAdapterPosition() == 1) {
                    intent = new Intent(context, ShouldersExercisesActivity.class);
                } else if (holder.getAdapterPosition() == 2) {
                    intent = new Intent(context, BicepsExercisesActivity.class);
                } else if (holder.getAdapterPosition() == 3) {
                    intent = new Intent(context, TricepsExercisesActivity.class);
                } else if (holder.getAdapterPosition() == 4) {
                    intent = new Intent(context, ForearmsExercisesActivity.class);
                } else if (holder.getAdapterPosition() == 5) {
                    intent = new Intent(context, BackExercisesActivity.class);
                } else if (holder.getAdapterPosition() == 6) {
                    intent = new Intent(context, AbsExercisesActivity.class);
                } else if (holder.getAdapterPosition() == 7) {
                    intent = new Intent(context, LegsExercisesActivity.class);
                } else intent = null;
                context.startActivities(new Intent[]{intent});*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return chest_exercises.size();
    }

    public void setChest_exercises(ArrayList<ChestExercise> chest_exercises) {
        this.chest_exercises = chest_exercises;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView id_ch_ex_it_ImageView;
        private TextView id_ch_ex_it_TextView;
        private ConstraintLayout ch_ex_item_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            id_ch_ex_it_ImageView = itemView.findViewById(R.id.id_ch_ex_it_ImageView);
            id_ch_ex_it_TextView = itemView.findViewById(R.id.id_ch_ex_it_TextView);
            ch_ex_item_layout = itemView.findViewById(R.id.id_ch_ex_it_Layout);
        }
    }
}

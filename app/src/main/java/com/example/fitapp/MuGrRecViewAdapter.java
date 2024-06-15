package com.example.fitapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// extends and whats written later we add additionally after we make class bellow with constructor
public class MuGrRecViewAdapter extends RecyclerView.Adapter<MuGrRecViewAdapter.ViewHolder> {

    private ArrayList<MuscleGroup> muscle_groups = new ArrayList<>();

    private Context context;

    // we need constructor for this ViewAdapter, so alt+ins
    public MuGrRecViewAdapter(Context context) {
        this.context = context;
    }


    // ctrl + i and implement all 3 mandatory methods

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.muscle_group_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id_mu_gr_it_TextView.setText(muscle_groups.get(position).getNameMuscleGroup());
        holder.id_mu_gr_it_ImageView.setImageResource(muscle_groups.get(position).getImageMuscleGroup());
        holder.mu_gr_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context, muscle_groups.get(holder.getAdapterPosition()).getNameMuscleGroup() + " selected", Toast.LENGTH_SHORT).show();

                // to make switch to correct muscle group layout/activity [0: Chest, 1: Shoulders, 2: Biceps, ...]]
                final Intent intent;

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
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return muscle_groups.size();
    }

    public void setMuscle_groups(ArrayList<MuscleGroup> muscle_groups) {
        this.muscle_groups = muscle_groups;
        /* notifyDataSetChanged();  // refresh recycler view if there are new muscle groups added later

        i dont need this because i wont change the existing muscle groups, but it will be usefull in
        adding custom exercises for the particular musle group

        and dont use so broad method like notifyDataSetChanged(), i.e. use: notifyItemInserted(int)

         */
    }

    // need to create this ViewHolder, this is the way by convention
    public class ViewHolder extends RecyclerView.ViewHolder{

        // if we want to have access to elements inside view object, add them as fields of this inner class
        private ImageView id_mu_gr_it_ImageView;
        private TextView id_mu_gr_it_TextView;

        private ConstraintLayout mu_gr_item_layout;  // to be able to set on click listener

        // to create constructor, press Alt+ins
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            id_mu_gr_it_ImageView = itemView.findViewById(R.id.id_mu_gr_it_ImageView);
            id_mu_gr_it_TextView = itemView.findViewById(R.id.id_mu_gr_it_TextView);
            mu_gr_item_layout = itemView.findViewById(R.id.id_mu_gr_it_Layout);
        }
    }

}

package com.example.fitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ViewHolder> {
    private final ExercisesInterface exercisesInterface;
    private ArrayList<ExercisesItem> exercisesItems = new ArrayList<>();
    private Context context;

    // we need constructor for this ViewAdapter, so alt+ins
    public ExercisesAdapter(Context context, ExercisesInterface exercisesInterface) {
        this.context = context;
        this.exercisesInterface = exercisesInterface;
    }


    // ctrl + i and implement all 3 mandatory methods

    // inflate the layout, giving look to each row
    @NonNull
    @Override
    public ExercisesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.muscle_group_item, parent, false);
        return new ExercisesAdapter.ViewHolder(view, exercisesInterface);
    }

    // assign values to each item (row) of the recycler view
    @Override
    public void onBindViewHolder(@NonNull ExercisesAdapter.ViewHolder holder, int position) {
        holder.exercises_ImageView1.setImageResource(exercisesItems.get(position).getImage());
        holder.exercises_TextView1.setText(exercisesItems.get(position).getExerciseName());
    }

    @Override
    public int getItemCount() {
        return exercisesItems.size();
    }

    public void setExercisesItems(ArrayList<ExercisesItem> exercisesItems) {
        this.exercisesItems = exercisesItems;
        notifyDataSetChanged();
        /* notifyDataSetChanged();  // refresh recycler view if there are new muscle groups added later

        i dont need this because i wont change the existing muscle groups, but it will be usefull in
        adding custom exercises for the particular musle group

        and dont use so broad method like notifyDataSetChanged(), i.e. use: notifyItemInserted(int)

         */
    }

    // need to create this ViewHolder, this is the way by convention
    public class ViewHolder extends RecyclerView.ViewHolder{

        // if we want to have access to elements inside view object, add them as fields of this inner class
        private ConstraintLayout exercises_Layout;  // to be able to set on click listener
        private ImageView exercises_ImageView1;
        private TextView exercises_TextView1;

        // to create constructor, press Alt+ins
        public ViewHolder(@NonNull View itemView, ExercisesInterface muscleGroupInterface) {
            super(itemView);
            context = itemView.getContext();
            exercises_Layout = itemView.findViewById(R.id.mu_group_it_Layout);
            exercises_ImageView1 = itemView.findViewById(R.id.mu_group_it_ImageView1);
            exercises_TextView1 = itemView.findViewById(R.id.mu_group_it_TextView1);

            // set on click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (muscleGroupInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            muscleGroupInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}

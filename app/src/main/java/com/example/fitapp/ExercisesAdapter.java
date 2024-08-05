package com.example.fitapp;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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
        holder.exercises_ImageView1.setImageResource(exercisesItems.get(position).getMuscle_image());
        holder.exercises_TextView1.setText(exercisesItems.get(position).getExerciseName());

        List<String> categories1 = exercisesItems.get(position).getPrimary();
        String categoriesString1 = TextUtils.join(", ", categories1);
        holder.exercises_TextView3.setText(categoriesString1);

        List<String> categories2 = exercisesItems.get(position).getSecondary();
        String categoriesString2 = TextUtils.join(", ", categories2);
        holder.exercises_TextView5.setText(categoriesString2);

        holder.exercises_TextView7.setText(exercisesItems.get(position).getPlace());
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
        private ImageView exercises_ImageView1;
        private TextView exercises_TextView1;
        private TextView exercises_TextView3;
        private TextView exercises_TextView5;
        private TextView exercises_TextView7;

        // to create constructor, press Alt+ins
        public ViewHolder(@NonNull View itemView, ExercisesInterface muscleGroupInterface) {
            super(itemView);
            context = itemView.getContext();  // to be able to set on click listener
            exercises_ImageView1 = itemView.findViewById(R.id.mu_group_it_ImageView1);
            exercises_TextView1 = itemView.findViewById(R.id.mu_group_it_TextView1);
            exercises_TextView3 = itemView.findViewById(R.id.mu_group_it_TextView3);  // primary
            exercises_TextView5 = itemView.findViewById(R.id.mu_group_it_TextView5);  // secondary
            exercises_TextView7 = itemView.findViewById(R.id.mu_group_it_TextView7);

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

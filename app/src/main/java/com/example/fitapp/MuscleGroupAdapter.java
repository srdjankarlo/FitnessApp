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

public class MuscleGroupAdapter extends RecyclerView.Adapter<MuscleGroupAdapter.ViewHolder> {
    private final MuscleGroupInterface muscleGroupInterface;
    private ArrayList<MuscleGroupItem> muscleGroupItems = new ArrayList<>();
    private Context context;

    // we need constructor for this ViewAdapter, so alt+ins
    public MuscleGroupAdapter(Context context, MuscleGroupInterface muscleGroupInterface) {
        this.context = context;
        this.muscleGroupInterface = muscleGroupInterface;
    }


    // ctrl + i and implement all 3 mandatory methods

    // inflate the layout, giving look to each row
    @NonNull
    @Override
    public MuscleGroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.muscle_group_item, parent, false);
        return new MuscleGroupAdapter.ViewHolder(view, muscleGroupInterface);
    }

    // assign values to each item (row) of the recycler view
    @Override
    public void onBindViewHolder(@NonNull MuscleGroupAdapter.ViewHolder holder, int position) {
        holder.MainMenuRecView_ImageView1.setImageResource(muscleGroupItems.get(position).getImage());
        holder.MainMenuRecView_TextView1.setText(muscleGroupItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return muscleGroupItems.size();
    }

    public void setMuscleGroupItems(ArrayList<MuscleGroupItem> muscleGroupItems) {
        this.muscleGroupItems = muscleGroupItems;
        /* notifyDataSetChanged();  // refresh recycler view if there are new muscle groups added later

        i dont need this because i wont change the existing muscle groups, but it will be usefull in
        adding custom exercises for the particular musle group

        and dont use so broad method like notifyDataSetChanged(), i.e. use: notifyItemInserted(int)

         */
    }

    // need to create this ViewHolder, this is the way by convention
    public class ViewHolder extends RecyclerView.ViewHolder{

        // if we want to have access to elements inside view object, add them as fields of this inner class
        private ConstraintLayout MainMenuRecView_Layout;  // to be able to set on click listener
        private ImageView MainMenuRecView_ImageView1;
        private TextView MainMenuRecView_TextView1;

        // to create constructor, press Alt+ins
        public ViewHolder(@NonNull View itemView, MuscleGroupInterface muscleGroupInterface) {
            super(itemView);
            context = itemView.getContext();
            MainMenuRecView_Layout = itemView.findViewById(R.id.mu_group_it_Layout);
            MainMenuRecView_ImageView1 = itemView.findViewById(R.id.mu_group_it_ImageView1);
            MainMenuRecView_TextView1 = itemView.findViewById(R.id.mu_group_it_TextView1);

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

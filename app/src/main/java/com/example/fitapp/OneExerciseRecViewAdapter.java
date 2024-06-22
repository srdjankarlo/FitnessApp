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

// extends and whats written later we add additionally after we make class bellow with constructor
public class OneExerciseRecViewAdapter extends RecyclerView.Adapter<OneExerciseRecViewAdapter.ViewHolder> {

    //private final OneExerciseRecViewInterface oneExerciseRecViewInterface;
    private ArrayList<OneExerciseRecViewItem> recViewItems = new ArrayList<>();
    private Context context;

    // we need constructor for this ViewAdapter, so alt+ins
    //public OneExerciseRecViewAdapter(Context context, OneExerciseRecViewInterface oneExerciseRecViewInterface) {
    //    this.context = context;
    //    this.oneExerciseRecViewInterface = oneExerciseRecViewInterface;
    //}
    public OneExerciseRecViewAdapter(Context context) {
        this.context = context;
    }


    // ctrl + i and implement all 3 mandatory methods

    // inflate the layout, giving look to each row
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_one_exercise_item, parent, false);
        //return new ViewHolder(view, oneExerciseRecViewInterface);
        return new ViewHolder(view);
    }

    // assign values to each item (row) of the recycler view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OneExerciseRecViewItem item = recViewItems.get(position);
        holder.item_date.setText(item.getOneExerciseRecViewDate());
        //holder.date.setText(recViewItems.get(position).getOneExerciseRecViewDate());
        holder.item_weight.setText(recViewItems.get(position).getOneExerciseRecViewWeight());
        holder.item_reps.setText(recViewItems.get(position).getOneExerciseRecViewReps());
        holder.item_duration.setText(recViewItems.get(position).getOneExerciseRecViewDuration());
        holder.item_rest.setText(recViewItems.get(position).getOneExerciseRecViewRest());
    }

    @Override
    public int getItemCount() {
        return recViewItems.size();
    }

    public void setItems(ArrayList<OneExerciseRecViewItem> mainMenuRecView_items) {
        this.recViewItems = mainMenuRecView_items;
        /* notifyDataSetChanged();  // refresh recycler view if there are new muscle items added later*/
    }

    // need to create this ViewHolder, this is the way by convention
    public class ViewHolder extends RecyclerView.ViewHolder{

        // if we want to have access to elements inside view object, add them as fields of this inner class
        //private ConstraintLayout MainMenuRecView_Layout;  // to be able to set on click listener
        private TextView item_date;
        private TextView item_weight;
        private TextView item_reps;
        private TextView item_duration;
        private TextView item_rest;

        // to create constructor, press Alt+ins
        //public ViewHolder(@NonNull View itemView, OneExerciseRecViewInterface mainMenuRecViewInterface) {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            //MainMenuRecView_Layout = itemView.findViewById(R.id.id_ac_ma_me_it_Layout);
            item_date = itemView.findViewById(R.id.id_ac_on_ex_it_TextView1);
            item_weight = itemView.findViewById(R.id.id_ac_on_ex_it_TextView2);
            item_reps = itemView.findViewById(R.id.id_ac_on_ex_it_TextView3);
            item_duration = itemView.findViewById(R.id.id_ac_on_ex_it_TextView4);
            item_rest = itemView.findViewById(R.id.id_ac_on_ex_it_TextView5);

            //// set on click
            //itemView.setOnClickListener(new View.OnClickListener() {
            //    @Override
            //    public void onClick(View view) {
            //        if (mainMenuRecViewInterface != null){
            //            int pos = getAdapterPosition();
            //
            //            if (pos != RecyclerView.NO_POSITION){
            //                mainMenuRecViewInterface.onItemClick(pos);
            //            }
            //        }
            //    }
            //});
        }
    }

    // Method to add an item
    public void addItem(OneExerciseRecViewItem item) {
        recViewItems.add(item);
        notifyItemInserted(recViewItems.size() - 1);
    }
}

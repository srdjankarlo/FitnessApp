package com.example.fitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

// extends and whats written later we add additionally after we make class bellow with constructor
public class OneExerciseAdapter extends RecyclerView.Adapter<OneExerciseAdapter.ViewHolder> {

    //private final OneExerciseRecViewInterface oneExerciseRecViewInterface;
    private ArrayList<OneExerciseItem> recViewItems = new ArrayList<>();
    private Context context;

    // we need constructor for this ViewAdapter, so alt+ins
    //public OneExerciseRecViewAdapter(Context context, OneExerciseRecViewInterface oneExerciseRecViewInterface) {
    //    this.context = context;
    //    this.oneExerciseRecViewInterface = oneExerciseRecViewInterface;
    //}
    public OneExerciseAdapter(Context context) {
        this.context = context;
    }


    // ctrl + i and implement all 3 mandatory methods

    // inflate the layout, giving look to each row
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_exercise_item, parent, false);
        //return new ViewHolder(view, oneExerciseRecViewInterface);
        return new ViewHolder(view);
    }

    // assign values to each item (row) of the recycler view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //OneExerciseItem item = recViewItems.get(position);
        //holder.item_date.setText(item.getitemDate());
        //holder.item_date.setText(String.valueOf(recViewItems.get(position).getItemDate()));
        holder.item_date.setText(formatTimestamp(recViewItems.get(position).getItemDate()));
        //holder.date.setText(recViewItems.get(position).getOneExerciseRecViewDate());
        holder.item_weight.setText(String.valueOf(recViewItems.get(position).getItemWeight()));
        holder.item_reps.setText(String.valueOf(recViewItems.get(position).getItemReps()));
        holder.item_duration.setText(String.valueOf(recViewItems.get(position).getItemDuration()));
        holder.item_rest.setText(String.valueOf(recViewItems.get(position).getItemRest()));
    }

    @Override
    public int getItemCount() {
        return recViewItems.size();
    }

    public void setItems(ArrayList<OneExerciseItem> mainMenuRecView_items) {
        this.recViewItems = mainMenuRecView_items;
        /* notifyDataSetChanged();  // refresh recycler view if there are new muscle items added later*/
    }

    private String formatTimestamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|dd-MM-yyyy", Locale.getDefault());
        return sdf.format(new Date(timestamp));
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
    public void addItem(OneExerciseItem item) {
        recViewItems.add(item);
        notifyItemInserted(recViewItems.size() - 1);  // update to last place
    }
}

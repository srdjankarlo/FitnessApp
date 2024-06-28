package com.example.fitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// extends and whats written later we add additionally after we make class bellow with constructor
public class DietRecViewAdapter extends RecyclerView.Adapter<DietRecViewAdapter.ViewHolder> {

    //private final OneExerciseRecViewInterface oneExerciseRecViewInterface;
    private List<DietItem> recViewItems = new ArrayList<>();
    private Context context;
    private OnItemClickListener listener;

    // we need constructor for this ViewAdapter, so alt+ins
    //public DietRecViewAdapter(Context context, OneExerciseRecViewInterface oneExerciseRecViewInterface) {
    //    this.context = context;
    //    this.oneExerciseRecViewInterface = oneExerciseRecViewInterface;
    //}
    public DietRecViewAdapter(Context context) {
        this.context = context;
    }


    // ctrl + i and implement all 3 mandatory methods

    // inflate the layout, giving look to each row
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet_item, parent, false);
        //return new ViewHolder(view, oneExerciseRecViewInterface);
        return new ViewHolder(itemView);
    }

    // assign values to each item (row) of the recycler view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(formatTimestamp(recViewItems.get(position).getDate()));
        holder.food_name.setText(recViewItems.get(position).getFood_name());
        holder.protein.setText(String.valueOf(recViewItems.get(position).getProteins()));
        holder.fat.setText(String.valueOf(recViewItems.get(position).getFats()));
        holder.carbohydrates.setText(String.valueOf(recViewItems.get(position).getCarbohydrates()));
        holder.sugar.setText(String.valueOf(recViewItems.get(position).getSugars()));
    }

    @Override
    public int getItemCount() {
        return recViewItems == null ? 0 : recViewItems.size();
    }

    public void setItems(List<DietItem> items) {
        this.recViewItems = items;
        notifyDataSetChanged();  // refresh recycler view if there are new muscle items added later
    }

    public DietItem getDietAtPosition(int position){
        return recViewItems.get(position);
    }

    private String formatTimestamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    // need to create this ViewHolder, this is the way by convention
    public class ViewHolder extends RecyclerView.ViewHolder{

        // if we want to have access to elements inside view object, add them as fields of this inner class
        //private ConstraintLayout MainMenuRecView_Layout;  // to be able to set on click listener
        private TextView date;
        private TextView food_name;
        private TextView protein;
        private TextView fat;
        private TextView carbohydrates;
        private TextView sugar;

        // to create constructor, press Alt+ins
        //public ViewHolder(@NonNull View itemView, OneExerciseRecViewInterface mainMenuRecViewInterface) {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            //MainMenuRecView_Layout = itemView.findViewById(R.id.id_ac_ma_me_it_Layout);
            date = itemView.findViewById(R.id.id_di_it_TextView0);
            food_name = itemView.findViewById(R.id.id_di_it_TextView1);
            protein = itemView.findViewById(R.id.id_di_it_TextView2);
            fat = itemView.findViewById(R.id.id_di_it_TextView3);
            carbohydrates = itemView.findViewById(R.id.id_di_it_TextView4);
            sugar = itemView.findViewById(R.id.id_di_it_TextView5);

            // set on click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(recViewItems.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(DietItem dietItem);
        void onItemLongClick(DietItem dietItem);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = (OnItemClickListener) listener;
    }

    // Method to add an item
    public void addItem(DietItem item) {
        recViewItems.add(item);
        notifyItemInserted(recViewItems.size() - 1);  // update to last place
    }
}

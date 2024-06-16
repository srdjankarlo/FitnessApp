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
import java.util.Objects;

// extends and whats written later we add additionally after we make class bellow with constructor
public class CommonRecViewAdapter extends RecyclerView.Adapter<CommonRecViewAdapter.ViewHolder> {

    private ArrayList<CommonRecycleViewItem> common_rec_view_items = new ArrayList<>();

    private Context context;

    // we need constructor for this ViewAdapter, so alt+ins
    public CommonRecViewAdapter(Context context) {
        this.context = context;
    }


    // ctrl + i and implement all 3 mandatory methods

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_rec_view_item_layout, parent, false);
        ViewHolder view_holder = new ViewHolder(view);

        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.co_re_vi_TextView.setText(common_rec_view_items.get(position).getCommonRecViewName());
        holder.co_re_vi_ImageView.setImageResource(common_rec_view_items.get(position).getCommonRecViewImage());
        String rec_view_type = common_rec_view_items.get(position).getCommonRecViewType();

        holder.co_re_vi_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context, muscle_groups.get(holder.getAdapterPosition()).getNameMuscleGroup() + " selected", Toast.LENGTH_SHORT).show();

                // to make switch to correct muscle group layout/activity [0: Chest, 1: Shoulders, 2: Biceps, ...]]
                // final Intent intent;

                // ToDo: make chest recycler view adapter and layout and try passing it as intent
                // in order to not create more activities cuz we need to set code for menu bar again
                // and that would be much unnecessary lines of code
                // see if back button will work

                /*// set different views in recycler view
                if (Objects.equals(rec_view_type, holder.itemView.getContext().getString(R.string.menu_item_exercises))){

                } else if (Objects.equals(rec_view_type, holder.itemView.getContext().getString(R.string.menu_item_my_workouts))
                {

                } else if (Objects.equals(rec_view_type, holder.itemView.getContext().getString(R.string.menu_item_diet))
                {

                } else if (Objects.equals(rec_view_type, holder.itemView.getContext().getString(R.string.menu_item_progress))
                {

                }*/

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
        return common_rec_view_items.size();
    }

    public void setCommon_rec_view_items(ArrayList<CommonRecycleViewItem> common_rec_view_items) {
        this.common_rec_view_items = common_rec_view_items;
        /* notifyDataSetChanged();  // refresh recycler view if there are new muscle groups added later

        i dont need this because i wont change the existing muscle groups, but it will be usefull in
        adding custom exercises for the particular musle group

        and dont use so broad method like notifyDataSetChanged(), i.e. use: notifyItemInserted(int)

         */
    }

    // need to create this ViewHolder, this is the way by convention
    public class ViewHolder extends RecyclerView.ViewHolder{

        // if we want to have access to elements inside view object, add them as fields of this inner class
        private ConstraintLayout co_re_vi_Layout;  // to be able to set on click listener
        private ImageView co_re_vi_ImageView;
        private TextView co_re_vi_TextView;

        // to create constructor, press Alt+ins
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            co_re_vi_Layout = itemView.findViewById(R.id.id_co_re_vi_it_la_Layout);
            co_re_vi_ImageView = itemView.findViewById(R.id.id_co_re_vi_it_la_ImageView);
            co_re_vi_TextView = itemView.findViewById(R.id.id_co_re_vi_it_la_TextView);
        }
    }

}

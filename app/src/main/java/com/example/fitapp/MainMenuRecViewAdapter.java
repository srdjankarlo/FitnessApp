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
public class MainMenuRecViewAdapter extends RecyclerView.Adapter<MainMenuRecViewAdapter.ViewHolder> {

    private final MainMenuRecViewInterface mainMenuRecViewInterface;
    private ArrayList<MainMenuRecViewItem> MainMenuRecView_items = new ArrayList<>();
    private Context context;

    // we need constructor for this ViewAdapter, so alt+ins
    public MainMenuRecViewAdapter(Context context, MainMenuRecViewInterface mainMenuRecViewInterface) {
        this.context = context;
        this.mainMenuRecViewInterface = mainMenuRecViewInterface;
    }


    // ctrl + i and implement all 3 mandatory methods

    // inflate the layout, giving look to each row
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_menu_item, parent, false);
        return new ViewHolder(view, mainMenuRecViewInterface);
    }

    // assign values to each item (row) of the recycler view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.MainMenuRecView_ImageView1.setImageResource(MainMenuRecView_items.get(position).getMainMenuViewImageView1());
        holder.MainMenuRecView_TextView1.setText(MainMenuRecView_items.get(position).getMainMenuRecViewTextView1());
        holder.MainMenuRecView_TextView2.setText(MainMenuRecView_items.get(position).getMainMenuRecViewTextView2());
        String rec_view_type = MainMenuRecView_items.get(position).getMainMenuRecViewType();
    }

    @Override
    public int getItemCount() {
        return MainMenuRecView_items.size();
    }

    public void setMainMenuRecView_items(ArrayList<MainMenuRecViewItem> mainMenuRecView_items) {
        this.MainMenuRecView_items = mainMenuRecView_items;
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
        private TextView MainMenuRecView_TextView2;

        // to create constructor, press Alt+ins
        public ViewHolder(@NonNull View itemView, MainMenuRecViewInterface mainMenuRecViewInterface) {
            super(itemView);
            context = itemView.getContext();
            MainMenuRecView_Layout = itemView.findViewById(R.id.id_ac_ma_me_it_Layout);
            MainMenuRecView_ImageView1 = itemView.findViewById(R.id.id_ac_ma_me_it_ImageView1);
            MainMenuRecView_TextView1 = itemView.findViewById(R.id.id_ac_ma_me_it_TextView1);
            MainMenuRecView_TextView2 = itemView.findViewById(R.id.id_ac_ma_me_it_TextView2);

            // set on click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mainMenuRecViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            mainMenuRecViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}

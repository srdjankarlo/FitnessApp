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
public class CommonRecViewAdapter extends RecyclerView.Adapter<CommonRecViewAdapter.ViewHolder> {

    private final ComRecViewInterface comRecViewInterface;
    private ArrayList<CommonRecycleViewItem> common_rec_view_items = new ArrayList<>();

    private Context context;

    // we need constructor for this ViewAdapter, so alt+ins
    public CommonRecViewAdapter(Context context, ComRecViewInterface comRecViewInterface) {
        this.context = context;
        this.comRecViewInterface = comRecViewInterface;
    }


    // ctrl + i and implement all 3 mandatory methods

    // inflate the layout, giving look to each row
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_menu_item, parent, false);
        return new ViewHolder(view, comRecViewInterface);
    }

    // assign values to each item (row) of the recycler view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.co_re_vi_ImageView1.setImageResource(common_rec_view_items.get(position).getCommonRecViewImageView1());
        holder.co_re_vi_TextView1.setText(common_rec_view_items.get(position).getCommonRecViewTextView1());
        holder.co_re_vi_TextView2.setText(common_rec_view_items.get(position).getCommonRecViewTextView2());
        String rec_view_type = common_rec_view_items.get(position).getCommonRecViewType();
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
        private ImageView co_re_vi_ImageView1;
        private TextView co_re_vi_TextView1;
        private TextView co_re_vi_TextView2;

        // to create constructor, press Alt+ins
        public ViewHolder(@NonNull View itemView, ComRecViewInterface comRecViewInterface) {
            super(itemView);
            context = itemView.getContext();
            co_re_vi_Layout = itemView.findViewById(R.id.id_ac_ma_me_it_Layout);
            co_re_vi_ImageView1 = itemView.findViewById(R.id.id_ac_ma_me_it_ImageView1);
            co_re_vi_TextView1 = itemView.findViewById(R.id.id_ac_ma_me_it_TextView1);
            co_re_vi_TextView2 = itemView.findViewById(R.id.id_ac_ma_me_it_TextView2);

            // set on click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (comRecViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            comRecViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }

}

package com.example.fitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.textViewExerciseName.setText(category.getName());
        holder.checkBox.setChecked(category.isSelected());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            category.setSelected(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView textViewExerciseName;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.ca_it_CheckBox);
            textViewExerciseName = itemView.findViewById(R.id.ca_it_TextView);
        }
    }

    // Method to get selected exercises
    public List<Category> getSelectedCategories() {
        List<Category> selectedExercises = new ArrayList<>();
        for (Category category : categoryList) {
            if (category.isSelected()) {
                selectedExercises.add(category);
            }
        }
        return selectedExercises;
    }
}

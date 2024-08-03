package com.example.fitapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImagePagerAdapter extends RecyclerView.Adapter<ImagePagerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Bitmap> imageBitmaps;

    public ImagePagerAdapter(Context context, ArrayList<Bitmap> imageBitmaps) {
        this.context = context;

        this.imageBitmaps = imageBitmaps;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_page_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bitmap imageBitmap = imageBitmaps.get(position);
        if (imageBitmap != null) {
            Glide.with(context)
                    .load(imageBitmap)
                    .into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.weight);
            Toast.makeText(context, "Error loading image", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return imageBitmaps.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.im_pa_it_ImageView);
        }
    }
}

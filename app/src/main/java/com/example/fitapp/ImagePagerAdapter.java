package com.example.fitapp;

import android.content.Context;
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
import java.util.List;

public class ImagePagerAdapter extends RecyclerView.Adapter<ImagePagerAdapter.ViewHolder> {
    private Context context;
    //private int[] imageUrls;
    private List<Uri> imageUris;

    //public ImagePagerAdapter(Context context, int[] imageUrls) {
    public ImagePagerAdapter(Context context, List<Uri> imageUris) {
        this.context = context;
        this.imageUris = imageUris;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_page_item, parent, false);
        return new ViewHolder(view);
    }

    // ArrayList<Uri>
    //@Override
    //public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //    //holder.imageView.setImageResource(imageUrls[position]);
    //    Uri imageUri = imageUris.get(position);
    //    Glide.with(context).load(imageUri).into(holder.imageView);
    //}

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uri imageUri = imageUris.get(position);
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(imageUri);
            Glide.with(context)
                    .load(inputStream)
                    .into(holder.imageView);
        } catch (FileNotFoundException e) {
            // Handle the exception, maybe show a default image
            holder.imageView.setImageResource(R.drawable.weight);
            Toast.makeText(context, "File not found for loading image", Toast.LENGTH_SHORT).show();
        } catch (SecurityException e) {
            // Handle the security exception, maybe show a default image or request the user to grant permission again
            holder.imageView.setImageResource(R.drawable.weight);
            Toast.makeText(context, "Permission issue with loading image", Toast.LENGTH_SHORT).show();
        }
    }

    //@Override
    //public int getItemCount() {
    //    return imageUrls.length;
    //}

    @Override
    public int getItemCount() {
        return imageUris.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.im_pa_it_ImageView);
        }
    }
}

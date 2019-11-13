package com.example.test_firebase_x;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView titleView;
    TextView gradeView;


    ViewHolder(View itemView)
    {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        titleView = itemView.findViewById(R.id.titleView);
        gradeView = itemView.findViewById(R.id.gradeView);

    }
}

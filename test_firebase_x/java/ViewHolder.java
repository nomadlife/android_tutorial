package com.example.test_firebase_x;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView titleView;
    TextView gradeView;
    CardView cvItem;

    ViewHolder(View itemView)
    {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        titleView = itemView.findViewById(R.id.titleView);
        gradeView = itemView.findViewById(R.id.gradeView);
        cvItem = itemView.findViewById(R.id.cardView);

    }


}

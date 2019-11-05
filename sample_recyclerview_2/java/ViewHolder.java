package com.example.test_recyclerview_2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView title;
    TextView grade;

    ViewHolder(View itemView)
    {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView2);
        title = itemView.findViewById(R.id.title);
        grade = itemView.findViewById(R.id.grade);
    }
}

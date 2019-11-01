package com.example.test_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>{

    private ArrayList<Movie> dataList;

    public HorizontalAdapter(ArrayList<Movie> data)
    {
        this.dataList = data;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        protected ImageView image;
        protected TextView title;

        public HorizontalViewHolder(View view)
        {
            super(view);
            image = view.findViewById(R.id.poster);
            title = view.findViewById(R.id.title);
        }
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_horizontal, null);

        return new HorizontalAdapter.HorizontalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder horizontalViewHolder, int position)
    {
        horizontalViewHolder
                .image
                .setImageResource(dataList.get(position).getResourceID());
        horizontalViewHolder
                .title
                .setText(dataList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}

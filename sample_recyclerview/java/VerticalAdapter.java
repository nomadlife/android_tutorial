package com.example.test_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder>{

    private ArrayList<ArrayList<Movie>> AllMovieList;
    private Context context;

    public VerticalAdapter(Context context, ArrayList<ArrayList<Movie>> data)
    {
        this.context = context;
        this.AllMovieList = data;
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{
        protected RecyclerView recyclerView;

        public VerticalViewHolder(View view)
        {
            super(view);

            this.recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewVertical);
        }
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_vertical, null);
        return new VerticalAdapter.VerticalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder verticalViewHolder, int position) {
        HorizontalAdapter adapter = new HorizontalAdapter(AllMovieList.get(position));

        verticalViewHolder.recyclerView.setHasFixedSize(true);
        verticalViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context
                , LinearLayoutManager.HORIZONTAL
                ,false));
        verticalViewHolder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return AllMovieList.size();
    }

}

package com.example.test_firebase_x;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.test_firebase_x.Model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Movie> myDataList;

    MyAdapter(ArrayList<Movie> dataList)
    {
        myDataList = dataList;
        Log.d("datalist","onAdapter - count - " + myDataList.size());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
//        Boolean testBoolean = ( myDataList.get(position).getImageResourceURL() == null );
//        Log.d("datalist","test logic - "+testBoolean);

        if (myDataList.get(position).getImageResourceURL() != null) {
            Picasso.get().load(myDataList.get(position).getImageResourceURL()).into(viewHolder.imageView);
        } else {
            viewHolder.imageView.setImageResource( myDataList.get(position).getImageResourceID());
        }

        viewHolder.titleView.setText(myDataList.get(position).getMovieTitle());
        viewHolder.gradeView.setText(myDataList.get(position).getMovieGrade());

    }

    @Override
    public int getItemCount()
    {
        //Adapter가 관리하는 전체 데이터 개수 반환
        return myDataList.size();
    }
}

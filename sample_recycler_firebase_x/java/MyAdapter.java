package com.example.test_firebase_x;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.test_firebase_x.Model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Movie> myDataList;
    private Context mContext;

    MyAdapter(Context context, ArrayList<Movie> dataList)
    {
        mContext = context;
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
    public void onBindViewHolder(ViewHolder viewHolder, final int position)
    {

        if (myDataList.get(position).getImageResourceURL() != null) {
            Picasso.get().load(myDataList.get(position).getImageResourceURL()).into(viewHolder.imageView);
        } else {
            viewHolder.imageView.setImageResource( myDataList.get(position).getImageResourceID());
        }

        viewHolder.titleView.setText(myDataList.get(position).getMovieTitle());
        viewHolder.gradeView.setText(myDataList.get(position).getMovieGrade());

        viewHolder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("click","test message - " + position);
                Toast.makeText(mContext, "test mesage!!! " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return myDataList.size();
    }


}

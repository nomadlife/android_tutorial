package com.example.sample_recyclerview_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Model> myDataList;


    MyAdapter(ArrayList<Model> dataList)
    {

        myDataList = dataList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(viewType == Code.ViewType.TEXT_TYPE)
        {
            view = inflater.inflate(R.layout.text_type, parent, false);
            return new TextTypeViewHolder(view);
        }
        else if(viewType == Code.ViewType.IMAGE_TYPE)
        {
            view = inflater.inflate(R.layout.image_type, parent, false);
            return new ImageTypeViewHolder(view);
        }
        else
        {
            view = inflater.inflate(R.layout.image_type2, parent, false);
            return new ImageTypeView2Holder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
    {
        if(viewHolder instanceof TextTypeViewHolder)
        {
            ((TextTypeViewHolder) viewHolder).title.setText(myDataList.get(position).getTitle());
        }
        else if(viewHolder instanceof ImageTypeViewHolder)
        {
            ((ImageTypeViewHolder) viewHolder).title.setText(myDataList.get(position).getTitle());
            ((ImageTypeViewHolder) viewHolder).image.setImageResource(myDataList.get(position).getImage());
        }
        else
        {
            ((ImageTypeView2Holder) viewHolder).title.setText(myDataList.get(position).getTitle());
            ((ImageTypeView2Holder) viewHolder).content.setText(myDataList.get(position).getContent());
            ((ImageTypeView2Holder) viewHolder).image.setImageResource(myDataList.get(position).getImage());

        }
    }

    @Override
    public int getItemCount()
    {
        return myDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return myDataList.get(position).getViewTtype();
    }



    public class TextTypeViewHolder extends RecyclerView.ViewHolder{
        TextView title;

        TextTypeViewHolder(View itemView)
        {
            super(itemView);

            title = itemView.findViewById(R.id.title);
        }
    }

    public class ImageTypeViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;

        ImageTypeViewHolder(View itemView)
        {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.background);
        }
    }

    public class ImageTypeView2Holder extends RecyclerView.ViewHolder{
        TextView content;
        TextView title;
        ImageView image;

        ImageTypeView2Holder(View itemView)
        {
            super(itemView);

            content = itemView.findViewById(R.id.contentView);
            title = itemView.findViewById(R.id.titleView);
            image = itemView.findViewById(R.id.imageView2);
        }
    }

}

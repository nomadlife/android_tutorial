package com.example.test_tab_recycler_x;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.test_tab_recycler_x.Model.Movie;


public class BlankFragment extends Fragment {
    private String title;
    private int resourceId;

    public BlankFragment() {
    }

    public static BlankFragment newInstance(Movie item) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString("title", item.getMovieTitle());
        args.putInt("resourceId",item.getImageResourceID());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("title");
            resourceId = getArguments().getInt("resourceId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f1_image_type, container, false);
        TextView tv = v.findViewById(R.id.f1_textView);
        tv.setText(title);
        ImageView iv = v.findViewById(R.id.f1_imageView);
        iv.setImageResource(resourceId);

        return v;
    }

}

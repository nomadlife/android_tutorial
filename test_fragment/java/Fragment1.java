package com.example.test_fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment1 extends Fragment {



    public static interface ImageSelectionCallback {
        public void onImageSelected(int position);
    }

    public ImageSelectionCallback callback;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ImageSelectionCallback) {
            callback = (ImageSelectionCallback) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        Button button1 = rootView.findViewById(R.id.button1);
        Button button2 = rootView.findViewById(R.id.button2);
        Button button3 = rootView.findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onImageSelected(0);
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onImageSelected(1);
                }
            }
        });


        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onImageSelected(2);
                }
            }
        });


        return rootView;
    }



}

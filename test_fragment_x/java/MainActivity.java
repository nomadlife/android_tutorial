package com.example.test_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.ImageSelectionCallback{

        Fragment1 fragment1;
        Fragment2 fragment2;

        int[] images = {R.drawable.dream01, R.drawable.dream02, R.drawable.dream03};

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        fragment1 = (Fragment1) manager.findFragmentById(R.id.list_fragment);
        fragment2 = (Fragment2) manager.findFragmentById(R.id.viewer_fragment);

        }

@Override
public void onImageSelected(int position) {
        fragment2.setImage(images[position]);
        }
}

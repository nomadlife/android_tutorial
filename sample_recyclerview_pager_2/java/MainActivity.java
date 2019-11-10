package com.example.sample_recyclerview_pager;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        ProductCardAdapter mCardAdapter = new ProductCardAdapter(getSupportFragmentManager(), items);
        rv.setAdapter(mCardAdapter);
    }

    public void initializeData() {
        items.add(new Product(R.drawable.movie1, "어벤져스"));
        items.add(new Product(R.drawable.movie2, "미션임파서블"));
        items.add(new Product(R.drawable.movie3, "아저씨"));
    }
}

package com.example.test_recyclerview_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeData();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager); // LayoutManager 등록
        recyclerView.setAdapter(new MyAdapter(dataList));  // Adapter 등록
    }

    public void InitializeData()
    {
        dataList = new ArrayList<>();

        dataList.add(new Movie(R.drawable.movie1,"어벤져스", "12세관람가"));
        dataList.add(new Movie(R.drawable.movie2,"미션임파서블", "15세관람가"));
        dataList.add(new Movie(R.drawable.movie3,"아쿠아맨", "12세관람가"));

        dataList.add(new Movie(R.drawable.movie4,"범죄도시", "15세관람가"));
        dataList.add(new Movie(R.drawable.movie5,"공공의적", "15세관람가"));
        dataList.add(new Movie(R.drawable.movie6,"맨인블랙", "15세관람가"));

        dataList.add(new Movie(R.drawable.movie7,"고질라", "12세관람가"));
        dataList.add(new Movie(R.drawable.movie8,"캡틴마블", "12세관람가"));
        dataList.add(new Movie(R.drawable.movie9,"아이언맨", "12세관람가"));
    }
}

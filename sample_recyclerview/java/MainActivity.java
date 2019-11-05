package com.example.test_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ArrayList<Movie>> allMovieList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeData();
        RecyclerView view = findViewById(R.id.recyclerViewVertical);

        VerticalAdapter verticalAdapter = new VerticalAdapter(this, allMovieList);

        view.setHasFixedSize(true);
        view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        view.setAdapter(verticalAdapter);
    }

    public void initializeData()
    {
        ArrayList<Movie> movieList1 = new ArrayList();

        movieList1.add(new Movie(R.drawable.movie1, "어벤져스"));
        movieList1.add(new Movie(R.drawable.movie2, "미션임파서블"));
        movieList1.add(new Movie(R.drawable.movie3, "아저씨"));

        allMovieList.add(movieList1);

        ArrayList<Movie> movieList2 = new ArrayList();

        movieList2.add(new Movie(R.drawable.movie4, "범죄도시"));
        movieList2.add(new Movie(R.drawable.movie5, "공공의적"));
        movieList2.add(new Movie(R.drawable.movie6, "맨인블랙"));

        allMovieList.add(movieList2);

        ArrayList<Movie> movieList3 = new ArrayList();

        movieList3.add(new Movie(R.drawable.movie7, "고질라"));
        movieList3.add(new Movie(R.drawable.movie8, "캡틴마블"));
        movieList3.add(new Movie(R.drawable.movie9, "아이언맨"));

        allMovieList.add(movieList3);
    }
}

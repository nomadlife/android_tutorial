package com.example.test_tab_recycler_x;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_tab_recycler_x.Model.Movie;

import java.util.ArrayList;


public class Fragment1 extends Fragment {

    private ArrayList<Movie> dataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1,container, false);
        this.InitializeData();

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager); // LayoutManager 등록
        recyclerView.setAdapter(new MyAdapter(dataList));  // Adapter 등록

        return rootView;
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

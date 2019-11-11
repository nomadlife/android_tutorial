package com.example.sample_recyclerview_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<Model> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeData();

        RecyclerView rv = findViewById(R.id.recycler_view);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);

        MyAdapter myAdapter = new MyAdapter(items);
        rv.setAdapter(myAdapter);

    }

    private void initializeData() {
        items.add(new Model(Code.ViewType.TEXT_TYPE, "카테고리 1번!", 0, null));
        items.add(new Model(Code.ViewType.IMAGE_TYPE, "텍스트뷰 아래에 이미지가 있는 뷰타입.", R.drawable.snow, null));
        items.add(new Model(Code.ViewType.IMAGE_TYPE_2, "안녕, 제목부분이 될거야", R.drawable.snow, "내용부분!"));
        items.add(new Model(Code.ViewType.IMAGE_TYPE, "다시 한 번 텍스트 옆에 이미지가 있는 뷰타입", R.drawable.snow, null));
        items.add(new Model(Code.ViewType.IMAGE_TYPE_2, "제목2!!", R.drawable.snow, "사진에 대한 설명?"));

        items.add(new Model(Code.ViewType.TEXT_TYPE, "카테고리 2번!", 0, null));
        items.add(new Model(Code.ViewType.IMAGE_TYPE, "새로운 카테고리 시작!.", R.drawable.snow, null));
        items.add(new Model(Code.ViewType.IMAGE_TYPE, "다음생엔 울창한 숲의 이름모를 나무로 태어나 평화로이 살다가 누군가의 유서가 되고 싶다.", R.drawable.snow, null));
        items.add(new Model(Code.ViewType.IMAGE_TYPE_2, "제목부분.", R.drawable.snow, "내용부분"));
    }
}

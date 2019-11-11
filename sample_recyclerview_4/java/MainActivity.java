package com.example.sample_recyclerview_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeData();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager manager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(manager); // LayoutManager 등록
        recyclerView.setAdapter(new MyAdapter(dataList));  // Adapter 등록
    }

    public void initializeData()
    {
        dataList = new ArrayList<>();

        dataList.add(new DataItem("사용자1님이 입장하셨습니다.", null,  Code.ViewType.CENTER_CONTENT));
        dataList.add(new DataItem("사용자2님이 입장하셨습니다.", null,  Code.ViewType.CENTER_CONTENT));
        dataList.add(new DataItem("안녕하세요", "사용자1",  Code.ViewType.LEFT_CONTENT));
        dataList.add(new DataItem("안녕하세요", "사용자2",  Code.ViewType.RIGHT_CONTENT));

    }
}

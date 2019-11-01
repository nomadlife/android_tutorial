package com.example.test_b_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PersonAdapter();

        adapter.addItem(new Person("User1", "010-1000-1000"));
        adapter.addItem(new Person("User2", "010-2000-2000"));
        adapter.addItem(new Person("User3", "010-3000-3000"));
        adapter.addItem(new Person("User4", "010-1000-1000"));
        adapter.addItem(new Person("User5", "010-2000-2000"));
        adapter.addItem(new Person("User6", "010-3000-3000"));
        adapter.addItem(new Person("User7", "010-1000-1000"));
        adapter.addItem(new Person("User8", "010-2000-2000"));
        adapter.addItem(new Person("User9", "010-3000-3000"));
        adapter.addItem(new Person("User10", "010-1000-1000"));
        adapter.addItem(new Person("User11", "010-2000-2000"));
        adapter.addItem(new Person("User12", "010-3000-3000"));

        recyclerView.setAdapter(adapter);

        adapter.setOnitemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "아이템 선택됨 :" + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

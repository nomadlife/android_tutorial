package com.example.test_firebase_x;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_firebase_x.Model.Movie;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private DatabaseReference moviesRef;
    private ArrayList<Movie> dataList;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager); // LayoutManager 등록


        moviesRef = FirebaseDatabase.getInstance().getReference().child("Movies");
        moviesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                dataList = new ArrayList<>();

                Log.d("datalist", "snapshot count - " + dataSnapshot.getChildrenCount());

                for (DataSnapshot movieSnapshot: dataSnapshot.getChildren()) {

                    Movie movie = new Movie();
                    movie.setMovieTitle(movieSnapshot.child("title").getValue().toString());
                    movie.setImageResourceURL(movieSnapshot.child("image").getValue().toString());
                    movie.setMovieGrade(movieSnapshot.child("grade").getValue().toString());

                    Log.d("datalist","dataList count - " + movie);
                    dataList.add(movie);
                }
                Log.d("datalist","dataList count - " + dataList.size());
                recyclerView.setAdapter(new MyAdapter(getApplicationContext(), dataList));  // Adapter 등록
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        this.InitializeData();
//        this.InitializeData0();

    }

    private void InitializeData0() {
        moviesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Log.d("datalist", "snapshot - " + dataSnapshot.getKey());

                Object object = dataSnapshot.getValue(Object.class);
                Log.d("datalist","Object - " + object.toString());

                Movie movie = new Movie();
                dataList.add(movie);

                recyclerView.setAdapter(new MyAdapter(getApplicationContext(), dataList));  // Adapter 등록
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void InitializeData() {

    }


    private void InitializeData2() {

        FirebaseDatabase movies = FirebaseDatabase.getInstance().getReference().child("Movies").getDatabase();

        Log.d("init2,getkey", "" + movies);

        Movie movie = new Movie();
        dataList.add(movie);

    }

    private void InitializeData3() {

        dataList.add(new Movie(R.drawable.movie1, "어벤져스", "15"));
        dataList.add(new Movie(R.drawable.movie2, "미션임파서블","15"));
        dataList.add(new Movie(R.drawable.movie3, "아저씨", "18"));
    }







}

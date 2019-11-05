package com.example.test_firebase_x;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_firebase_x.Model.Movie;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {


    private DatabaseReference moviesRef;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesRef =  FirebaseDatabase.getInstance().getReference().child("Movies");


        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager); // LayoutManager 등록

        
        
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Movie> options = new FirebaseRecyclerOptions.Builder<Movie>()
                .setQuery(moviesRef, Movie.class)
                .build();

        FirebaseRecyclerAdapter<Movie, ViewHolder> adapter = new FirebaseRecyclerAdapter<Movie, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Movie movie) {

                viewHolder.title.setText(movie.getMovieTitle());
                viewHolder.grade.setText(movie.getMovieGrade());
                Picasso.get().load(movie.getImageResourceID()).into(viewHolder.imageView);

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);
                ViewHolder holder = new ViewHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);  // Adapter 등록
        adapter.startListening();
    }


    private void temp(){

    }
}

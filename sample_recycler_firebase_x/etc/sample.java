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
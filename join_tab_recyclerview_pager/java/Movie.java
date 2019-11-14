package com.example.test_tab_recycler_x.Model;

public class Movie {
    private int imageResourceID;
    private String movieTitle;
    private String movieGrade;

    public Movie(int id, String title, String grade)
    {
        this.imageResourceID = id;
        this.movieTitle = title;
        this.movieGrade = grade;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieGrade() {
        return movieGrade;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieGrade(String movieGrade) {
        this.movieGrade = movieGrade;
    }
}

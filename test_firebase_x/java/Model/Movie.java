package com.example.test_firebase_x.Model;

import org.json.JSONObject;

import java.util.Map;

public class Movie {
    private String movieTitle;
    private String movieGrade;
    private int imageResourceID;
    private String imageResourceURL;


    //constructors
    public Movie(int image, String title, String grade)
    {
        this.imageResourceID = image;
        this.movieTitle = title;
        this.movieGrade = grade;
    }

    public Movie(String image, String title, String grade)
    {
        this.imageResourceURL = image;
        this.movieTitle = title;
        this.movieGrade = grade;
    }


    public Movie()
    {

    }


    // getters
    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getImageResourceURL() {
        return imageResourceURL;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieGrade() {
        return movieGrade;
    }


    //setters
    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public void setImageResourceURL(String imageResourceURL) {
        this.imageResourceURL = imageResourceURL;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieGrade(String movieGrade) {
        this.movieGrade = movieGrade;
    }



}

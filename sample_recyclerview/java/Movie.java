package com.example.test_recyclerview;

public class Movie {

    private String title;
    private int ResourceID;

    public Movie(int id, String title)
    {
        this.ResourceID = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getResourceID() {
        return ResourceID;
    }

}

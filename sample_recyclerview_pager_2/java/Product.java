package com.example.sample_recyclerview_pager;

/**
 * Created by kevin on 2017. 10. 24..
 */

public class Product {
    private String title;
    private int ResourceID;

    public Product(int id, String title)
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

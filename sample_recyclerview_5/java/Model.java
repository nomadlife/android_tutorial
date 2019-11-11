package com.example.sample_recyclerview_5;

public class Model{
    private int viewTtype;
    private String title;
    private int image;
    private String content;

    public Model(int viewTtype, String title, int image, String content) {
        this.viewTtype = viewTtype;
        this.title = title;
        this.image = image;
        this.content = content;
    }

    public int getViewTtype() {
        return viewTtype;
    }

    public void setViewTtype(int viewTtype) {
        this.viewTtype = viewTtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

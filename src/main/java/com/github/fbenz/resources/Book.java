package com.github.fbenz.resources;

public class Book {

    private String id;

    private String title;

    private Integer pages;

    public Book() {
        // for Jackson
    }

    public Book(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}

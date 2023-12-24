package org.example.book;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private int id;
    private String title;
    private String author;


    public Book(String title, String author) {
        id = COUNTER.getAndIncrement();
        this.title = title;
        this.author = author;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

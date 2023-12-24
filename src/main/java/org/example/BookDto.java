package org.example;

public class BookDto {
    private String id;
    private String title;
    private String author;

    public BookDto(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public BookDto(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public BookDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "id=" + id + ", Название=" + title + ", Автор=" + author;
    }
}

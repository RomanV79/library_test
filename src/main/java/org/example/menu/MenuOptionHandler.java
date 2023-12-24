package org.example.menu;

import org.example.book.BookDao;

public interface MenuOptionHandler {
    BookDao bookDao = new BookDao();
    public void handle();
}

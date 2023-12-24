package org.example.menu;

import org.example.book.BookDao;
import org.example.book.BookDto;

import java.util.List;

public class Option1Handler implements MenuOptionHandler {
    private final BookDao bookDao = new BookDao();

    @Override
    public void handle() {
        List<BookDto> books = bookDao.getAll();
        if (books.isEmpty()) {
            System.out.println("В библиотеке нет ни одной книги");
        } else {
            books.forEach(System.out::println);
        }
    }
}

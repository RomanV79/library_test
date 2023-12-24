package org.example.menu;

import org.example.book.Book;
import org.example.book.BookDao;
import org.example.book.BookDto;
import org.example.util.Prop;

public class Option2Handler implements MenuOptionHandler {
    private final BookDao bookDao = new BookDao();
    
    @Override
    public void handle() {
        BookDto bookDto = new BookDto();
        System.out.println("Введите название книги");
        bookDto.setTitle(Prop.scanner.nextLine());
        System.out.println("Введите автора книги");
        bookDto.setAuthor(Prop.scanner.nextLine());
        bookDao.insert(new Book(bookDto.getTitle(), bookDto.getAuthor()));
    }
}

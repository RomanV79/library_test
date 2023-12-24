package org.example.menu;

import org.example.Librarian;
import org.example.book.BookDao;

public class OptionExitHandler implements MenuOptionHandler {
    private Librarian librarian;

    public OptionExitHandler(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public void handle() {
        librarian.setExit(true);
    }
}

package org.example.menu;

import org.example.book.BookDao;
import org.example.util.Prop;

public class Option4Handler implements MenuOptionHandler {
    private final BookDao bookDao = new BookDao();
    
    @Override
    public void handle() {
        System.out.println("Введите id книги которую хотите удалить: ");
        String id = Prop.scanner.nextLine();
        if (bookDao.delete(id)) {
            System.out.println("Книга успешно удалена");
        } else {
            System.out.println("Не существует книги с таким id");
        }
    }
}

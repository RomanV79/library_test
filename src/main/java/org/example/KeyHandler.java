package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class KeyHandler {

    private final BookDao bookDao = new BookDao();

    public void handleMainMenu(Librarian librarian) {
        String command;
        try {
            command = Prop.scanner.nextLine();
            switch (command) {
                case "1" -> {
                    List<BookDto> books = bookDao.getAll();
                    if (books.isEmpty()) {
                        System.out.println("В библиотеке нет ни одной книги");
                    } else {
                        books.forEach(System.out::println);
                    }
                }
                case "2" -> {
                    BookDto bookDto = new BookDto();
                    System.out.println("Введите название книги");
                    bookDto.setTitle(Prop.scanner.nextLine());
                    System.out.println("Введите автора книги");
                    bookDto.setAuthor(Prop.scanner.nextLine());
                    bookDao.insert(new Book(bookDto.getTitle(), bookDto.getAuthor()));
                }
                case "3" -> {
                    System.out.println("Введите id книги которую хотите изменить: ");
                    String id = Prop.scanner.nextLine();
                    if (bookDao.edit(id)){
                        System.out.println("Книга успешно изменена");
                    } else {
                        System.out.println("Не существует книги с таким id");
                    }
                }
                case "4" -> {
                    System.out.println("Введите id книги которую хотите удалить: ");
                    String id = Prop.scanner.nextLine();
                    if (bookDao.delete(id)) {
                        System.out.println("Книга успешно удалена");
                    } else {
                        System.out.println("Не существует книги с таким id");
                    }
                }
                case "5" -> librarian.setExit(true);
//                default -> System.out.println("Неизвестная команда, введите верную команду...");
                default -> throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Неизвестная команда, введите верную команду...");
        }
    }
}

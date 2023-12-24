package org.example.book;

import org.example.util.Prop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BookDao {

    public List<BookDto> getAll() {
        List<BookDto> listBook = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(getFile()))) {
            br.lines().forEach(line -> {
                String[] bookArr = line.split(";");
                listBook.add(new BookDto(bookArr[0], bookArr[1], bookArr[2]));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listBook;
    }

    public void insert(Book book) {
        String str = book.getId() + ";" + book.getTitle() + ";" + book.getAuthor();
        try (FileWriter fw = new FileWriter(getFile(), true)) {
            fw.write(str + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean edit(String id) {
        AtomicBoolean result = new AtomicBoolean(false);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(getFile()))) {
            br.lines().forEach(line -> {
                String[] bookArr = line.split(";");
                if (bookArr[0].equals(id)) {
                    BookDto bookDto = new BookDto();
                    System.out.println("Текущее название книги: " + bookArr[1]);
                    System.out.println("Введите новое название книги: ");
                    bookDto.setTitle(Prop.scanner.nextLine());
                    System.out.println("Текущий автор книги: " + bookArr[2]);
                    System.out.println("Введите нового автора книги: ");
                    bookDto.setAuthor(Prop.scanner.nextLine());
                    stringBuilder.append(bookArr[0]);
                    stringBuilder.append(";");
                    stringBuilder.append(bookDto.getTitle());
                    stringBuilder.append(";");
                    stringBuilder.append(bookDto.getAuthor());
                    stringBuilder.append("\n");
                    result.set(true);
                } else {
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter(getFile(), false)) {
            fw.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.get();
    }

    public boolean delete(String id) {
        AtomicBoolean result = new AtomicBoolean(false);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(getFile()))) {
            br.lines().forEach(line -> {
                String[] bookArr = line.split(";");
                if (!bookArr[0].equals(id)) {
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                } else {
                    result.set(true);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter(getFile(), false)) {
            fw.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.get();
    }

    private File getFile() {
        return new File(Prop.relativePath);
    }
}

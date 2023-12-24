package org.example;

public class Librarian {
    Action action = new Action();
    Table table = new Table();
    KeyHandler keyHandler = new KeyHandler();

    public void setExit(boolean exit) {
        isExit = exit;
    }

    private boolean isExit = false;


    public static void main(String[] args) {

        Librarian librarian = new Librarian();
        librarian.start(librarian);

    }

    private void start(Librarian librarian) {
        action.init();

        while (!isExit) {
            table.render();
            keyHandler.handleMainMenu(librarian);
        }

        Prop.scanner.close();
        System.out.println("Библиотека закрывается, до завтра...");
    }
}
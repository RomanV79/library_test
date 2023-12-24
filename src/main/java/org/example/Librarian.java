package org.example;

import org.example.menu.KeyHandler;
import org.example.menu.Table;
import org.example.util.Action;
import org.example.util.Prop;

public class Librarian {
    Action action = new Action();
    Table table = new Table();

    public void setExit(boolean exit) {
        isExit = exit;
    }

    private boolean isExit = false;

    public static void main(String[] args) {
        Librarian librarian = new Librarian();
        librarian.start();
    }

    private void start() {
        action.init();
        KeyHandler keyHandler = new KeyHandler(this);

        while (!isExit) {
            table.render();
            keyHandler.handleMainMenu();
        }

        Prop.scanner.close();
        System.out.println("Библиотека закрывается, до завтра...");
    }
}
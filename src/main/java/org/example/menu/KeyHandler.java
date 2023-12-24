package org.example.menu;

import org.example.Librarian;
import org.example.util.Prop;

import java.util.HashMap;
import java.util.Map;

public class KeyHandler {

    private Librarian librarian;
    private final Map<String, MenuOptionHandler> menuHandlers = new HashMap<>();
    public KeyHandler(Librarian librarian) {
        this.librarian = librarian;
        menuHandlers.put("1", new Option1Handler());
        menuHandlers.put("2", new Option2Handler());
        menuHandlers.put("3", new Option3Handler());
        menuHandlers.put("4", new Option4Handler());
        menuHandlers.put("exit", new OptionExitHandler(librarian));
    }

    public void handleMainMenu() {
        String command;
        command = Prop.scanner.nextLine();
        if (menuHandlers.containsKey(command)) {
            menuHandlers.get(command).handle();
        } else {
            handleDefault();
        }
    }

    private void handleDefault() {
        System.out.println("Неизвестная команда, введите верную команду...");
    }
}

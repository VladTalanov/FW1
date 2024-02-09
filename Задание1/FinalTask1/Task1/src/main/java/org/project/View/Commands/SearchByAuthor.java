package org.project.View.Commands;

import org.project.View.ConsoleUI;

public class SearchByAuthor extends Commands {

    public SearchByAuthor(ConsoleUI consoleUI) {
        super("Поиск по автору", consoleUI);
    }

    @Override
    public void execute() {
        System.out.println("ищу по автору...");
        super.getConsoleUI().searchByAuthor();
    }
}

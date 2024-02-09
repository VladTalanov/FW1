package org.project.View.Commands;

import org.project.View.ConsoleUI;

public class SearchByID extends Commands {

    public SearchByID(ConsoleUI consoleUI) {
        super("Поиск по инвентарному номеру", consoleUI);
    }

    @Override
    public void execute() {
        System.out.println("ищу...");
        super.getConsoleUI().searchByID();
    }
}

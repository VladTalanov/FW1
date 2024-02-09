package org.project.View.Commands;

import org.project.View.ConsoleUI;

public class AddEdition extends Commands {

    public AddEdition(ConsoleUI consoleUI) {
        super("Добавить в реестр...", consoleUI);
    }

    @Override
    public void execute() {
        System.out.println("добавляю...");
        super.getConsoleUI().addEdition();
    }
}

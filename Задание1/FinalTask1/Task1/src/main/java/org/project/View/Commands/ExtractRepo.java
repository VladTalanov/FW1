package org.project.View.Commands;

import org.project.View.ConsoleUI;

public class ExtractRepo extends Commands {

    public ExtractRepo(ConsoleUI consoleUI) {
        super("Достать из архива...", consoleUI);
    }

    @Override
    public void execute() {
        System.out.println("достаю...");
        super.getConsoleUI().extractRepo();
    }
}

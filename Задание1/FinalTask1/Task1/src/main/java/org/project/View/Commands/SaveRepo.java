package org.project.View.Commands;

import org.project.View.ConsoleUI;

public class SaveRepo extends Commands {

    public SaveRepo(ConsoleUI consoleUI) {
        super("Сохранить в архив...", consoleUI);
    }

    @Override
    public void execute() {
        System.out.println("сохраняю...");
        super.getConsoleUI().saveRepo();
    }
}

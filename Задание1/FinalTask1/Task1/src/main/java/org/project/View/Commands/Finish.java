package org.project.View.Commands;

import org.project.View.ConsoleUI;

public class Finish extends Commands {

    public Finish(ConsoleUI consoleUI) {
        super("Закончить работу", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().finish();
    }
}

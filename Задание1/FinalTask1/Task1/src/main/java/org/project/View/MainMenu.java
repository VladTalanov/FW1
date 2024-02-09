package org.project.View;

import org.project.View.Commands.*;

import java.util.ArrayList;
import java.util.List;

/**
 * основное меню для работы с репозиторием
 */
public class MainMenu {
    private List<Commands> mainMenu;

    public MainMenu(ConsoleUI consoleUI) {
        this.mainMenu = new ArrayList<>();
        this.mainMenu.add(new AddEdition(consoleUI));
        this.mainMenu.add(new SearchByID(consoleUI));
        this.mainMenu.add(new SearchByAuthor(consoleUI));
        this.mainMenu.add(new ExtractRepo(consoleUI));
        this.mainMenu.add(new SaveRepo(consoleUI));
        this.mainMenu.add(new Finish(consoleUI));

    }

    public String printMenu() {
        StringBuilder stringMenu = new StringBuilder();
        stringMenu.append("\nМеню:\n");
        for (int i = 0; i < mainMenu.size(); i++) {
            stringMenu.append(i + 1);
            stringMenu.append(". ");
            stringMenu.append(mainMenu.get(i).getDescription());
            stringMenu.append("\n");
        }
        return stringMenu.toString();

    }

    public int getSize() {
        return mainMenu.size();
    }

    public void execute(int choice) {
        Commands command = mainMenu.get(choice - 1);
        command.execute();
    }
}

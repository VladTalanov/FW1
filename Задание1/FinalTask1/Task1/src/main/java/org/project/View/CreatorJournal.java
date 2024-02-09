package org.project.View;

import org.project.Model.Edition.*;

import java.util.List;

public class CreatorJournal implements FactoryEdition {
    private ConsoleUI consoleUI;

    @Override
    public String description() {
        return "Журналы (периодические издания)";
  }

    @Override
    public Edition create(ConsoleUI consoleUI) {
        System.out.println("создаю журнал...");

        String title = consoleUI.getTitle();
        String description = consoleUI.getDescription();
        List<Person> authors = consoleUI.createListAuthors();
        int year = consoleUI.getYear("Введите год выпуска журнала:");
        int number = consoleUI.getNumber();

        return new Journal (title, description, authors, year, number);
    }


}

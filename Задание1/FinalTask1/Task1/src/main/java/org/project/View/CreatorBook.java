package org.project.View;

import org.project.Model.Edition.Book;
import org.project.Model.Edition.Edition;
import org.project.Model.Edition.Person;

import java.util.List;

public class CreatorBook implements FactoryEdition {
    private ConsoleUI consoleUI;

    @Override
    public String description() {
        return "Книга, брошюра";
    }

    @Override
    public Edition create(ConsoleUI consoleUI) {
        System.out.println("создаем книгу...");
        String title = consoleUI.getTitle();
        String description = consoleUI.getDescription();

        System.out.println("добавление автора(ов):");
        List<Person> authors = consoleUI.createListAuthors();

        int year = consoleUI.getYear("Введите год издания книги:");

        return new Book(title, description, authors, year);
    }
}

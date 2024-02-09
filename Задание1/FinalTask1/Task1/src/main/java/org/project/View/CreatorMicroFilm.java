package org.project.View;

import org.project.Model.Edition.*;

import java.util.List;

public class CreatorMicroFilm implements FactoryEdition {
    //private ConsoleUI consoleUI;

    @Override
    public String description() {
        return "Микрофильмы";
  }

    @Override
    public Edition create(ConsoleUI consoleUI) {
        System.out.println("создаю микрофильм...");

        String title = consoleUI.getTitle();
        String description = consoleUI.getDescription();
        List<Person> authors = consoleUI.createListAuthors();
        int year = consoleUI.getYear("Введите год записи микрофильма:");
        WidthFilm widthFilm = consoleUI.getWidthFilm();

        return new Microfilm(title, description, authors, year, widthFilm);
    }


}

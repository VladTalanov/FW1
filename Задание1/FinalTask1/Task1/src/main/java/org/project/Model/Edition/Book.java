package org.project.Model.Edition;

import java.util.List;

public class Book extends Edition {

    public Book(String title, String description, List<Person> authors, int year) {
        super(title, description, authors, year);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Книга: " + this.getTitle() + ", Автор: ");
        for (Person item : this.getAuthors()) {
            info.append(item.toString());
            info.append(", ");
        }
        info.append(" Год: ");
        info.append(this.getYear());
        return info.toString();
    }

    @Override
    public String fullInfo() {
        StringBuilder info = new StringBuilder("Book:\n  Title: " + this.getTitle());
        info.append("\n  Описание: ");
        info.append(this.getDescription());
        info.append("\n  Автор: ");

        for (Person item : this.getAuthors()) {
            info.append(item.toString());
            info.append(", ");
        }
        info.append("\n  Год публикации: ");
        info.append(this.getYear());
        return info.toString();

    }


}

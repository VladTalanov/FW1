package org.project.Model.Edition;

import java.io.Serializable;
import java.util.List;

/**
 * Носитель информации, который храниться в библиотеке
 */
public abstract class Edition implements Serializable {
    private final String title;
    private final String description;
    private final List<Person> authors;
    private final int year;

    public Edition(String title, String description, List<Person> authors, int year) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Edition: " +
                "title: '" + title + '\'' +
                ", description: " + description;
    }

    public abstract String fullInfo();
}

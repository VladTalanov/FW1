package org.project.Model.Edition;


import java.util.List;

public class Journal extends Edition {
    private int number;

    public Journal(String title, String description, List<Person> authors,  int year, int number) {
        super(title, description, authors, year);
        this.number = number;
    }


    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Journal: " + this.getTitle() + ", author(s)= ");
        for (Person item : this.getAuthors()) {
            info.append(item.toString());
            info.append(", ");
        }
        info.append("year ");
        info.append(this.getYear());
        info.append(", N ");
        info.append(this.number);
        return info.toString();

    }

    @Override
    public String fullInfo() {
        StringBuilder info = new StringBuilder("Journal:\n  Title: " + this.getTitle());
        info.append("\n  Description: ");
        info.append(this.getDescription());
        info.append("\n  Author(s): ");

        for (Person item : this.getAuthors()) {
            info.append(item.toString());
            info.append(", ");
        }
        info.append("\n  Year publisher: ");
        info.append(this.getYear());
        info.append("\n  Number: ");
        info.append(this.number);
        return info.toString();

    }
}
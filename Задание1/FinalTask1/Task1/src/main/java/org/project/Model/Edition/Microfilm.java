package org.project.Model.Edition;

import java.util.List;

public class Microfilm extends Edition {
    private WidthFilm width;

    public Microfilm(String title, String description, List<Person> authors, int year, WidthFilm widthFilm) {
        super(title, description, authors, year);
        this.width = widthFilm;

    }

    @Override
    public String fullInfo() {
        StringBuilder info = new StringBuilder("Microfilm:\n  Title: " + this.getTitle());
        info.append("\n  Description: ");
        info.append(this.getDescription());
        info.append("\n  Author(s): ");
        for (Person item : this.getAuthors()) {
            info.append(item.toString());
            info.append(", ");
        }
        info.append("\n  Year create: ");
        info.append(this.getYear());
        info.append("\n  Width film: ");
        info.append(this.width);

        return info.toString();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Microfilm: '" + this.getTitle() + "', author(s)= ");
        for (Person item : this.getAuthors()) {
            info.append(item.toString());
            info.append(", ");
        }
        info.append(", year ");
        info.append(this.getYear());
        info.append(", width ");
        info.append(this.width);

        return info.toString();

    }

    public WidthFilm getWidth() {
        return width;
    }
}

package org.project.Model.Edition;

import java.util.List;

public class Book extends Edition {

    public Book(String title, String description, List<Person> authors, int year) {
        super(title, description, authors, year);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("�����: " + this.getTitle() + ", �����: ");
        for (Person item : this.getAuthors()) {
            info.append(item.toString());
            info.append(", ");
        }
        info.append(" ���: ");
        info.append(this.getYear());
        return info.toString();
    }

    @Override
    public String fullInfo() {
        StringBuilder info = new StringBuilder("Book:\n  Title: " + this.getTitle());
        info.append("\n  ��������: ");
        info.append(this.getDescription());
        info.append("\n  �����: ");

        for (Person item : this.getAuthors()) {
            info.append(item.toString());
            info.append(", ");
        }
        info.append("\n  ��� ����������: ");
        info.append(this.getYear());
        return info.toString();

    }


}

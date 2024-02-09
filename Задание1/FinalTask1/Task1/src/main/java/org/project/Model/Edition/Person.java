package org.project.Model.Edition;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Класс персоналий (авторов...)
 */
public class Person implements Serializable {
    private final String firstName;
    private final String lastName;



    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

}

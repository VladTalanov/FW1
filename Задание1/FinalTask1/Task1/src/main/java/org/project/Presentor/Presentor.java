package org.project.Presentor;

import org.project.Model.Edition.Edition;
import org.project.Model.Edition.Person;
import org.project.Service.Service;
import org.project.View.View;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Presentor {
    private  View consoleUI;
    private Service service;

    public Presentor(View consoleUI) {
        this.consoleUI = consoleUI;
        service = new Service();
    }

    public void addEdition(Edition edition) {
        service.addEdition(edition);
    }

    public void addAuthor(Person person) {
        service.addAuthor(person);
    }


    public void extractRepo(String file) throws IOException, ClassNotFoundException {
        service.extractRepo(file);
    }

    public void saveRepo(String file) throws IOException {
        service.saveRepo(file);
    }

    public List<Edition> searchByAuthor(String firstName) {
        if (firstName.isEmpty()){
            return service.getListEdition();
        }
        return service.searchByAuthor(firstName);
    }

    public Edition searchByID(int id) {
        return service.searchByID(id);
    }


    public List<Person> getListAuthors() {
        return service.getListAuthors();
    }
}

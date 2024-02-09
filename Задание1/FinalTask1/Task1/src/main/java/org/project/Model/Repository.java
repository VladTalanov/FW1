package org.project.Model;

import org.project.Model.Edition.Edition;
import org.project.Model.Edition.Person;

import java.util.HashMap;
import java.util.List;

public interface Repository {
    void addEdition(Edition edition);
    List<Person> getAuthorsList();
    void addAuthor(Person author);
    HashMap<Integer, Edition> getRegistryList();


}

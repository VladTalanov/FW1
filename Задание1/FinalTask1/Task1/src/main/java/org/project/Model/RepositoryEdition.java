package org.project.Model;

import org.project.Model.Edition.Edition;
import org.project.Model.Edition.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositoryEdition implements Serializable, Repository {
    private final HashMap<Integer, Edition> registryList;
    private final List<Person> authorsList;

    private static int id = 0;

    public RepositoryEdition() {
        registryList = new HashMap<>();
        authorsList = new ArrayList<>();
   }

    public void addEdition(Edition edition) {
        id = registryList.size() + 1;
        registryList.put(id, edition);
    }

    public List<Person> getAuthorsList() {
        return this.authorsList;
    }

    public HashMap<Integer, Edition> getRegistryList() {
        return registryList;
    }

    public void addAuthor(Person author) {
        authorsList.add(author);
    }
}

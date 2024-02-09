package org.project.Service;

import org.project.Model.Edition.Edition;
import org.project.Model.Edition.Person;
import org.project.Model.RepositoryEdition;

import java.io.*;
import java.util.List;

/**
 * класс для работы с репозиторием
 */
public class Service {
    private RepositoryEdition repositoryEdition;

    public Service() {
        this.repositoryEdition = new RepositoryEdition();
    }

    public void addEdition(Edition edition) {
        repositoryEdition.addEdition(edition);
    }

    public void addAuthor(Person author) {
        repositoryEdition.addAuthor(author);
    }

    public List<Edition> searchByAuthor(String firstName) {
        return repositoryEdition.getRegistryList().values()
                .stream()
                .filter(x -> x.getAuthors().stream().anyMatch(s -> s.getFirstName().equalsIgnoreCase(firstName)))
                .toList();
    }

    public Edition searchByID(int id) {
        Edition resultSearch = repositoryEdition.getRegistryList().get(id);
        return resultSearch;
    }

    /**
     * сохранение репозитория в файл
     */
    public void saveRepo(String file) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(this.repositoryEdition);
    }

    /**
     * восстановление БД из файла
     *
     * @param file имя файла
     */
    public void extractRepo(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        this.repositoryEdition = (RepositoryEdition) inputStream.readObject();

    }

    public List<Person> getListAuthors() {
        return repositoryEdition.getAuthorsList();
    }

    public List<Edition> getListEdition() {
        return repositoryEdition.getRegistryList().values().stream().toList();
    }
}

package org.project.View;

import org.project.Model.Edition.*;
import org.project.Presentor.Presentor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * класс для коммуникации с пользователем
 */

public class ConsoleUI implements View {
    private final Scanner scanner;
    private final Presentor presentor;
    private boolean work;
    private final MainMenu menu;


    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presentor = new Presentor(this);
        this.work = true;
        this.menu = new MainMenu(this);

    }

    @Override
    public void start() {

        while (work) {
            int choiceInt;
            System.out.println(menu.printMenu());

            System.out.println("выберите пункт меню:");
            String choiceStr = scanner.nextLine();
            if (choiceStr.matches("[0-9]+")) {
                choiceInt = Integer.parseInt(choiceStr);
                if ((choiceInt <= menu.getSize()) && (choiceInt > 0)) {
                    menu.execute(choiceInt);
                } else {
                    System.out.println("Пункта меню с таким номером нет. Попробуйте еще раз");
                }
            } else {
                System.out.println("Необходимо ввести номер пункта меню. Попробуйте еще раз");
            }
        }
    }

    /**
     * добавление объекта в репозиторий
     */
    public void addEdition() {
        int choiceInt;
        boolean poll = true;
        while (poll) {
            System.out.println("выберите тип издания:\n");
            ListEdition listEdition = new ListEdition();
            System.out.println(listEdition.printListEdition());
            String choiceStr = scanner.nextLine();

            if (choiceStr.matches("[0-9]+")) {
                choiceInt = Integer.parseInt(choiceStr);
                if ((choiceInt <= listEdition.getEditionList().size()) && (choiceInt > 0)) {
                    Edition edition = listEdition.getEditionList().get(choiceInt - 1).create(this);
                    presentor.addEdition(edition);
                    System.out.println("add edition: " + edition.toString());
                    poll = false;
                } else {
                    System.out.println("Пункта меню с таким номером нет. Попробуйте еще раз");
                }
            } else {
                System.out.println("Необходимо ввести номер пункта меню. Попробуйте еще раз");
            }
        }
    }


    //region Create Eddition
    protected String getTitle() {
        System.out.println("Введите название:");
        return scanner.nextLine();
    }

    protected String getDescription() {
        System.out.println("Введите описание:");
        return scanner.nextLine();
    }

    protected int getYear(String text) {

        int year = 0;
        boolean pull = false;
        while (!pull) {
            System.out.println(text);
            String yearStr = scanner.nextLine();
            if (yearStr.matches("[0-9]+")) {
                year = Integer.parseInt(yearStr);
                if (year < 0 || year > LocalDate.now().getYear()) {
                    System.out.println("год должен быть меньше текущей даты и больше нуля. попробуйте еще раз.");
                } else {
                    pull = true;
                }
            } else {
                System.out.println("Нужно ввести год цифрами. попробуйте еще раз");
            }
        }
        return year;
    }

    protected int getNumber() {
        boolean pull = true;
        int numberInt = 0;
        while (pull) {
            System.out.println("Введите номер:");
            String numberStr = scanner.nextLine();
            if (numberStr.matches("[0-9]+")) {
                numberInt = Integer.parseInt(numberStr);
                pull = false;
            } else {
                System.out.println("необходимо ввести число. попробуйте еще раз");
            }
        }
        return numberInt;
    }

    protected List<Person> createListAuthors() {
        List<Person> authorsEdditionList = new ArrayList<>();

        boolean pull = false;
        while (!pull) {
            Person person = getAuthor();
            authorsEdditionList.add(person);
            System.out.println("добавлен автор издания: " + person.toString());
            System.out.println("добавить еще одного автора?: (Y - да/любой символ - нет)");
            String choice = scanner.nextLine();
            if (!choice.matches("[Yy]")) {
                pull = true;
            }
        }
        return authorsEdditionList;
    }

    private Person getAuthor() {
        Person author = null;
        boolean pull = false;
        int i;
        while (!pull) {
            System.out.println("укажите номер автора из списка:");
            i = 1;
            for (Person item : presentor.getListAuthors()) {
                System.out.printf("%d - %s\n", i++, item.toString());
            }
            System.out.printf("%d - ДОБАВИТЬ нового автора\n", i);
            String choiceStr = scanner.nextLine();
            if (choiceStr.matches("[0-9]+")) {
                int choiceInt = Integer.parseInt(choiceStr);
                if (choiceInt == i) {
                    author = createAuthor();
                    pull = true;
                } else if (choiceInt < i && choiceInt > 0) {
                    author = presentor.getListAuthors().get(choiceInt - 1);
                    pull = true;

                } else {
                    System.out.println("Автора с таким номером нет. Попробуйте еще раз");
                }
            } else {
                System.out.println("Нужно ввести номер цифрами. попробуйте еще раз");
            }
        }
        return author;
    }

    protected WidthFilm getWidthFilm() {
        WidthFilm widthFilm = null;
        boolean pull = true;
        String widthStr;
        int sizeEnum = WidthFilm.values().length;
        while (pull) {
            System.out.println("укажите размер пленки (порядковый номер):");

            for (WidthFilm item : WidthFilm.values()) {
                System.out.println(item.ordinal() + " - " + item.getTitle());
            }
            widthStr = scanner.nextLine();
            if (widthStr.matches("[0-9]+") && Integer.parseInt(widthStr) < sizeEnum) {
                widthFilm = WidthFilm.values()[Integer.parseInt(widthStr)];
                pull = false;
            } else {
                System.out.println("попробуйте еще раз. Нужно указать число от 0 до " + (sizeEnum - 1));
            }


        }
        return widthFilm;
    }

    //endregion Create Eddition

    /**
     * восстановления данных их файла
     */
    public void extractRepo() {
        System.out.println("Введите имя архива из которого нужно восстановить данные (без расширения)");
        String nameRepo = scanner.nextLine() + ".txt";
        try {
            presentor.extractRepo(nameRepo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("данные из архива не могут быть распакованы: " + e.getMessage());
        }
    }

    /**
     * сохранение репозитория в файл
     */
    public void saveRepo() {
        System.out.println("Введите имя файла для сохранения (без расширения)");
        String nameRepo = scanner.nextLine() + ".txt";
        try {
            presentor.saveRepo(nameRepo);
        } catch (IOException e) {
            System.out.println("данные не могут быть сохранены: " + e.getMessage());
        }

    }

    /**
     * поиск по автору либо вывод всего списка репозитория. результат выводится на экран
     */
    public void searchByAuthor() {
        System.out.println("Введите фамилию автора (либо нажмите Enter, для вывода всего списка)");
        String firstName = scanner.nextLine();
        List<Edition> result = presentor.searchByAuthor(firstName);
        if (result.isEmpty()) {
            System.out.printf("Изданий автора %s в каталоге нет\n", firstName);
        } else {
            System.out.println("результат поиска:");
            printListEdition(result);
        }
    }

    private void printListEdition(List<Edition> editions) {
        editions.forEach(System.out::println);
    }

    /**
     * поиск по инвентарному номеру. результат поиска выводит на экран
     */
    public void searchByID() {
        System.out.println("Введите инвентарный номер издания");
        String invNumberStr = scanner.nextLine();
        if (invNumberStr.matches("[0-9]+")) {
            int invNumber = Integer.parseInt(invNumberStr);
            Edition result = presentor.searchByID(invNumber);
            if (result == null) {
                System.out.println("Объекта с таким инвентарным номером нет в реестре");
            } else {
                System.out.println("результат поиска:\n" + result.fullInfo());
            }
        } else {
            System.out.println("Номер некорректен. Он должен быть числовым");
        }
    }

    /**
     * окончание работы
     */
    public void finish() {
        System.out.println("сохранить изменения в БД? (Y - да/любой символ - нет)");
        String choice = scanner.nextLine();
        if (choice.matches("[Yy]")) {
            saveRepo();
        }
        System.out.println("пока...");
        work = false;
    }

    /**
     * создание автора
     *
     * @return объект класса Person
     */
    private Person createAuthor() {
        System.out.println("Введите фамилию автора");
        String firstName = scanner.nextLine();
        System.out.println("Введите имя автора");
        String lastName = scanner.nextLine();

        Person person = new Person(firstName, lastName);
        presentor.addAuthor(person);

        return person;
    }


}

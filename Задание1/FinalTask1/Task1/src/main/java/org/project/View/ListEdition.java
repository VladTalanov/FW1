package org.project.View;

import java.util.ArrayList;
import java.util.List;

/**
 * лист для выбора типа издания
 */
public class ListEdition {
    private static List<FactoryEdition> editionList;
    public ListEdition() {
        editionList = new ArrayList<>();
        editionList.add(new CreatorBook());
        editionList.add(new CreatorJournal());
        editionList.add(new CreatorMicroFilm());

    }

    public String printListEdition(){
        StringBuilder stringlist = new StringBuilder();
        stringlist.append("Тип издания:\n");
        for (int i = 0; i < editionList.size(); i++) {
            stringlist.append(i + 1);
            stringlist.append(". ");
            stringlist.append(editionList.get(i).description());
            stringlist.append("\n");
        }
        return stringlist.toString();
    }

    public List<FactoryEdition> getEditionList() {
        return editionList;
    }
}

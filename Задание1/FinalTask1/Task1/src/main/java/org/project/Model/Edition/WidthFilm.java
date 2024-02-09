package org.project.Model.Edition;

public enum WidthFilm {
    MR16 ("micro roll 16"),
    MR35 ("micro roll 35"),
    MC16 ("micro cut 16"),
    MC35 ("micro cut 35");

    private String title;

    WidthFilm(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

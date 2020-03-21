package com.dicodingtraining.tumbas.Model;

public class Favorite {
    private int Image;
    private String Tittle;

    public Favorite(int image, String tittle) {
        Image = image;
        Tittle = tittle;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }
}

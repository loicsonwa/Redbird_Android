package com.example.spacetablayout.catalogue_manager;

public class CatalogueModel {
    public String Name;
    public int Image;

    public CatalogueModel() {
    }

    public CatalogueModel(String name, int image) {
        Name = name;
        Image = image;
    }
    public void changeText1(String text){
        Name = text;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}

package models;

import interfaces.BookAttribute;

public class Author implements BookAttribute {

    private String name;


    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package models;


import interfaces.BookAttribute;

public class Book implements BookAttribute {

    private String name;
    private String author;

    private String genre;

    public Book(String name, String author, String genre){
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Book {name=" + name + ", Author=" + author + ", " + "genre=" + genre + "}";
    }


}

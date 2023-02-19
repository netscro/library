package controllers;

import interfaces.BookAttribute;
import utils.Validator;

import java.io.IOException;
import java.util.List;

import static views.LibraryView.*;

public class LibraryController {

    static int choice;

    public static void fillList(List<BookAttribute> list, BookAttribute value) {
        list.add(value);
    }

    public static String getIndexFromList(List<BookAttribute> list, int index) {
        return list.get(index - 1).getName();
    }

    public static void removeIndexFromList(List<BookAttribute> list, int index) {
        BookAttribute bookAttribute = list.get(index - 1);
        System.out.printf("%s: %s - Was deleted.\n",
                bookAttribute.getClass().getSimpleName(),
                bookAttribute.getName());
        list.remove(index);
    }

    public static void remover(int userInput) throws IOException {
        switch (userInput) {
            case 1:
                System.out.println("Please chose number of Genre to delete");
                getOutputs(genres);
                choice = Validator.getInt();
                removeIndexFromList(genres, choice);
            case 2:
                System.out.println("Please chose number of Author to delete");
                getOutputs(authors);
                choice = Validator.getInt();
                removeIndexFromList(authors, choice);
            case 3:
                System.out.println("Please chose number of Book to delete");
                getOutputs(books);
                choice = Validator.getInt();
                removeIndexFromList(books, choice);
            case 9:
                System.exit(0);
            default:
                throw new IllegalArgumentException("Only Available: 1, 2, 3 or 9 option.");
        }
    }

}

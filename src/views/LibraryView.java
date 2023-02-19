package views;

import interfaces.BookAttribute;
import models.Author;
import models.Book;
import models.Genre;
import utils.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static controllers.LibraryController.*;

public class LibraryView {

    public static List<BookAttribute> genres = new ArrayList<>();
    public static List<BookAttribute> authors = new ArrayList<>();
    public static List<BookAttribute> books = new ArrayList<>();

    String title;
    String name;
    static int deletionChoice;
    int count;
    int genreNumberChoice;
    int authorNumberChoice;

    public void getInputs() throws IOException {


        System.out.println("How many genres you want to add?");
        count = Validator.getInt();

        System.out.printf("Please add %s genres.\n", count);
        getGenreInput(count);

        System.out.println("How many authors you want to add?");
        count = Validator.getInt();

        System.out.printf("Please add %s authors.\n", count);
        getAuthorInput(count);

        System.out.println("How many books you want to add?");
        count = Validator.getInt();

        System.out.printf("Please add %s books.\n", count);
        getBookInput(count);
        getBookOutputs(books);

        while (deletionChoice != 9) {
            System.out.println("Chose deletion option:");
            System.out.println("1. Delete Genre");
            System.out.println("2. Delete Author");
            System.out.println("3. Delete Book");
            System.out.println("9. Exit");
            deletionChoice = Validator.getInt();
            try {
                remover(deletionChoice);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nothing to delete.");
            }

        }
    }

    public void getGenreInput(int maxCount) throws IOException {
        do {
            title = "Enter the Genre name: ";
            System.out.print(title);
            name = Validator.getString();
            Genre genre = new Genre();
            genre.setName(name);
            fillList(genres, genre);
        } while (genres.size() != maxCount);
    }

    public void getAuthorInput(int maxCount) throws IOException {
        do {
            title = "Enter the Author's name and surname in one line: ";
            System.out.print(title);
            name = Validator.getString();
            Author author = new Author();
            author.setName(name);
            fillList(authors, author);
        } while (authors.size() != maxCount);
    }

    public void getBookInput(int maxCount) throws IOException {

        while (books.size() != maxCount) {
            title = "Enter the Book name: ";
            System.out.print(title);
            name = Validator.getString();

            title = "Choose the number of Genre from the list: ";
            System.out.println(title);
            getOutputs(genres);
            genreNumberChoice = Validator.getInt();
            System.out.println("Chosen genre: " + getIndexFromList(genres, genreNumberChoice));

            title = "Choose the number of Author from the list: ";
            System.out.println(title);
            getOutputs(authors);
            authorNumberChoice = Validator.getInt();
            System.out.println("Chosen author: " + getIndexFromList(authors, authorNumberChoice));

            Book book = new Book(
                    name,
                    getIndexFromList(genres, genreNumberChoice),
                    getIndexFromList(authors, authorNumberChoice)
            );

            fillList(books, book);

        }

    }

    public static void getOutputs(List<BookAttribute> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s. %s\n", (i + 1), list.get(i).getName());
        }
    }

    public void getBookOutputs(List<BookAttribute> list) {
        System.out.println("Books list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s. %s\n", (i + 1), list.get(i).toString());
        }
    }

}

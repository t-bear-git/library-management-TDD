package library;

import java.util.ArrayList;

public class BookLibrary {

    private ArrayList<Book> books = new ArrayList<>();

    public BookLibrary() {
        /*books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K Rowlings", "Fantasy", "1997", false, null, null));
        books.add(new Book("Harry Potter and the Goblet of Fire", "J.K Rowlings", "Fantasy", "2000", false, null, null));
        books.add(new Book("High Fidelity", "Nick Hornby", "Comedy", "1995", false, null, null));
        books.add(new Book("Glöm Mig", "Alex Schulman", "Biografi", "2016", false, null, null));*/
    }

    public ArrayList<Book> getBooksFromLibrary() {
        return books;
    }

}

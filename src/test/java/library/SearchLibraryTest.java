package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchLibraryTest {

    private BookLibrary bookLibrary;
    private SearchLibrary searchLibrary;
    private static Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K Rowlings", "Fantasy", "1997-06-26", false, null, null);
    private static Book book2 = new Book("Harry Potter and the Goblet of Fire", "J.K Rowlings", "Fantasy", "2000-07-08", false, null, null);
    private static Book book3 = new Book("High Fidelity", "Nick Hornby", "Comedy", "1995-09-16", false, null, null);
    private static Book book4 = new Book("Glöm Mig", "Alex Schulman", "Biography", "2016-10-03", false, null, null);
    private ArrayList<Book> books;


    @BeforeEach
    void setup() {
        bookLibrary = mock(BookLibrary.class);
        searchLibrary = new SearchLibrary(bookLibrary);
        books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
    }

    // Invalid Search inputs
    @Test
    void should_ReturnEmptyHashSet_when_SearchInputLessThen2Chars() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchLibrary.findBooksFromSearch("H");

        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnEmptyHashSet_when_InvalidSearchInput() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchLibrary.findBooksFromSearch("-?");

        assertEquals(expected, actual);
    }

    // Search for genre
    @Test
    void should_ReturnBooks_when_GenreAsSearchWord() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(book1);
        expected.add(book2);

        HashSet<Book> actual = searchLibrary.findBooksFromSearch("Fantasy");

        assertEquals(expected, actual);
    }

    // Search for Title
    @Test
    void should_ReturnBooks_when_TitleAsSearchWord() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(book1);
        expected.add(book2);

        HashSet<Book> actual = searchLibrary.findBooksFromSearch("Harry Potter");

        assertEquals(expected, actual);
    }

    // Search for Author
    @Test
    void should_ReturnBooks_when_AuthorFirstNameAsSearchWord() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(book3);

        HashSet<Book> actual = searchLibrary.findBooksFromSearch("Nick");

        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnBooks_when_AuthorLastNameAsSearchWord() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(book4);

        HashSet<Book> actual = searchLibrary.findBooksFromSearch("Schulman");

        assertEquals(expected, actual);
    }

    // Search for release date
    @Test
    void should_ReturnBooks_when_ReleaseYearAsSearchWord() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(book4);

        HashSet<Book> actual = searchLibrary.findBooksFromSearch("2016");

        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnBooks_when_ReleaseDateAsSearchWord() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(book3);

        HashSet<Book> actual = searchLibrary.findBooksFromSearch("1995-09-16");

        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnBooks_when_PartReleaseDateAsSearchWord() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(book3);
        expected.add(book4);

        HashSet<Book> actual = searchLibrary.findBooksFromSearch("16");

        assertEquals(expected, actual);
    }


    // Search for books with the highest grade
    @Test
    void should_ReturnBooks_when_SearchForHighestGrade() {
        when(bookLibrary.getBooksFromLibrary()).thenReturn(books);

        ArrayList<Integer> topGrades = new ArrayList<>();
        topGrades.add(5);
        topGrades.add(4);
        book1.setGrades(topGrades);

        ArrayList<Integer> bottomGrades = new ArrayList<>();
        bottomGrades.add(2);
        bottomGrades.add(1);
        book2.setGrades(bottomGrades);

        HashSet<Book> expected = new HashSet<>();
        expected.add(book1);

        HashSet<Book> actual = searchLibrary.findHighestGradeBooks();

        assertEquals(expected, actual);
    }



}
package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class LibraryServiceTest {

    private Book book1;
    private Book book2;
    private LibraryService library;
    private Person lender1;
    private Person lender2;

    @BeforeEach
    public void setup() {
        book1 = new Book("War and Peace", "Tolstoy", "Drama", "1955", false, null, null);
        book2 = new Book("High Fidelity", "Nick Hornby", "Comedy", "1995", false, null, null);

        lender1 = new Person("Teddie");
        lender2 = new Person("Freddie");

        library = new LibraryService("Test Library");

        library.addBook(book1);
        library.addBook(book2);
        library.addPerson(lender1);
        library.addPerson(lender2);
    }

    @Test
    public void should_ReturnEmptyLibrary() {
        library.removeBook(book1);
        library.removeBook(book2);
        assertEquals(0, library.getBooks().size());
    }

    @Test
    public void should_Return3BooksWhen1AddedToLibrary() {
        library.addBook(new Book("Harry Potter", "J.K Rowlings", "Fantasy", "2000", false, null, null));
        assertEquals(3, library.getBooks().size());
    }

    @Test
    public void should_Return2BooksWhenLibraryIsUnchanged() {
        assertEquals(2, library.getBooks().size());
    }

    @Test
    public void should_Return1BookWhen1RemovedFromLibrary() {
        library.removeBook(book1);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void should_ReturnTrueWhenBookIsCheckedOut() {
        library.checkOut(book1, lender1);
        assertTrue(book1.isCheckedOut());
    }

    @Test
    public void should_ReturnFalseWhenBookIsCheckedIn() {
        library.checkOut(book1, lender2);
        System.out.println(book1.isCheckedOut());
        library.checkIn(book1);
        assertFalse(book1.isCheckedOut());
    }

    @Test
    public void should_ReturnAllBooksNotCheckedOut() {
        ArrayList<Book> testBooks = library.getAvailableBooks();
        for (Book aBook : testBooks) {
            System.out.println(aBook.getTitle());
        }
        assertEquals(2, testBooks.size());
    }

    @Test
    public void should_Return1BookWhen1IsCheckedOut() {
        library.checkOut(book2, lender1);
        ArrayList<Book> testBooks = library.getAvailableBooks();
        assertEquals(1, testBooks.size());
    }

    @Test
    public void should_Return0BooksWhen2IsCheckedOut() {
        library.checkOut(book2, lender1);
        library.checkOut(book1, lender1);
        ArrayList<Book> testBooks = library.getAvailableBooks();
        assertEquals(0, testBooks.size());
    }

    @Test
    public void should_Return1BookWhen1IsCheckedBackIn() {
        library.checkOut(book2, lender1);
        library.checkOut(book1, lender1);
        library.checkIn(book1);
        ArrayList<Book> testBooks = library.getAvailableBooks();
        assertEquals(1, testBooks.size());
    }

    @Test
    public void should_Return2BooksWhen2IsCheckedBackIn() {
        library.checkOut(book2, lender1);
        library.checkOut(book1, lender1);
        library.checkIn(book1);
        library.checkIn(book2);
        ArrayList<Book> testBooks = library.getAvailableBooks();
        assertEquals(2, testBooks.size());
    }


    @DisplayName("Adding 1 comment")
    @Test
    public void should_Add1CommentToBook() {
        String comment = "Torr och Tråkig bok. Rekommenderas ej.";
        library.addCommentToBook(book1, comment);

        ArrayList<String> bookComments = new ArrayList<>();
        bookComments.add(comment);

        ArrayList<String> actual = book1.getComments();

        assertEquals(bookComments, actual);
    }

    @DisplayName("Adding 2 comments")
    @Test
    public void should_AddAnotherCommentToBook() {

        String firstComment = "Torr och Tråkig bok. Rekommenderas ej.";
        String secondComment = "Helt okej bok. Trög start men blir bättre efterhand.";

        library.addCommentToBook(book1, firstComment);
        library.addCommentToBook(book1, secondComment);

        ArrayList<String> bookComments = new ArrayList<>();
        bookComments.add(firstComment);
        bookComments.add(secondComment);

        ArrayList<String> actual = book1.getComments();

        assertEquals(bookComments, actual);
    }

    @DisplayName("Adding grade to book")
    @Test
    public void should_AddGradeToBook() {
        int grade = 2;
        ArrayList<Integer> bookGrades = new ArrayList<>();
        bookGrades.add(grade);
        library.addGradeToBook(book1, grade);

        ArrayList<Integer> actual = book1.getGrades();

        assertEquals(bookGrades, actual);
    }

    @DisplayName("Adding more grades to book")
    @Test
    public void should_AddMoreGradesToBook() {
        int grade1 = 2;
        int grade2 = 1;
        int grade3 = 5;
        ArrayList<Integer> bookGrades = new ArrayList<>();
        bookGrades.add(grade1);
        bookGrades.add(grade2);
        bookGrades.add(grade3);
        library.addGradeToBook(book1, grade1);
        library.addGradeToBook(book1, grade2);
        library.addGradeToBook(book1, grade3);

        ArrayList<Integer> actual = book1.getGrades();

        assertEquals(bookGrades, actual);
    }


}
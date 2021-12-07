package library;

import java.util.ArrayList;

public class LibraryService {

    private String name;
    ArrayList<Book> books;
    ArrayList<Person> persons;

    public LibraryService(String name) {
        this.name = name;
        books = new ArrayList<Book>();
        persons = new ArrayList<Person>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void addBook(Book b1) {
        this.books.add(b1);
    }

    public void removeBook(Book b1) {
        this.books.remove(b1);
    }

    public void addPerson(Person p1) {
        this.persons.add(p1);
    }

    public boolean checkOut(Book b1, Person p1) {
        if (b1.getPerson() == null && !b1.isPaid()) {
            b1.setPerson(p1);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIn(Book b1) {
        if (b1.getPerson() != null && b1.isPaid()) {
            b1.setPerson(null);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> result = new ArrayList<Book>();
        for (Book aBook : this.getBooks()) {
            if (aBook.getPerson() == null) {
                result.add(aBook);
            }
        }
        return result;
    }

    public void addCommentToBook(Book book1, String comment) {

        ArrayList<String> comments = new ArrayList<>();

        if (book1.getComments() != null) {
            comments.addAll(book1.getComments());
        }

        comments.add(comment);
        book1.setComments(comments);

    }

    public void addGradeToBook(Book book1, int grade) {

        ArrayList<Integer> grades = new ArrayList<>();

        if (book1.getGrades() != null) {
            grades.addAll(book1.getGrades());
        }

        grades.add(grade);
        book1.setGrades(grades);
    }

}

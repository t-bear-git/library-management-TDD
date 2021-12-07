package library;

import java.util.ArrayList;

public class Book {

    private String title;
    private String author;
    private String genre;
    private String year;
    private boolean checkedOut;
    private ArrayList<Integer>grade;
    private ArrayList<String>comments;

    Person person;

    public Book(String title, String author, String genre, String year, boolean checkedOut, ArrayList<Integer>grade, ArrayList<String>comments) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.checkedOut = checkedOut;
        this.grade = grade;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public boolean isCheckedOut() {
        if (this.getPerson() != null) {
            checkedOut = true;
            return true;
        } else {
            checkedOut = false;
            return false;
        }

    }

    public ArrayList<Integer> getGrades() {
        return grade;
    }

    public void setGrades(ArrayList<Integer> grade) {
        this.grade = grade;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public void setPerson(Person p2) {
        this.person = p2;

    }

    public Person getPerson() {
        return this.person;
    }

    public boolean isPaid() {
        if (this.getPerson() != null) {
            return true;
        } else {
            return false;
        }
    }


}

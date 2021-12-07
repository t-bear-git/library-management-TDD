package library;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchLibrary {

    private final BookLibrary bookLibrary;

    public SearchLibrary(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    public HashSet<Book> findBooksFromSearch(String input) {
        ArrayList<Book> books = bookLibrary.getBooksFromLibrary();

        HashSet<Book> searchResult = new HashSet<>();

        input = input.trim();

        if (input.length() >= 2) {

            HashSet<String> searchWords = searchSeparateWords(input);
            System.out.println("searchWords: " + searchWords);

            for (Book book : books) {
                for (String searchWord : searchWords) {

                    if (book.getTitle().contains(searchWord) || book.getAuthor().contains(searchWord) ||
                            book.getGenre().contains(searchWord) ||
                            book.getYear().contains(searchWord)) {
                        searchResult.add(book);
                    }
                }
            }
        }
        System.out.println("searchResult: " + searchResult);
        return searchResult;
    }

    // Return searchResult with highest grade.
    public HashSet<Book> findHighestGradeBooks() {

        ArrayList<Book> books = bookLibrary.getBooksFromLibrary();
        HashSet<Book> searchResult = new HashSet<>();
        double gradeResult = 0;

        for (Book book : books) {

            if (book.getGrades() != null) {

                for (int i = 0; i < book.getGrades().size(); i++) {

                    gradeResult += book.getGrades().get(i);
                }
                gradeResult = gradeResult / book.getGrades().size();
                if (gradeResult >= 4) {
                    searchResult.add(book);
                }
            }
        }
        return searchResult;
    }


    // handle separate input words.
    public static HashSet<String> searchSeparateWords(String input) {
        HashSet<String> searchWords = new HashSet<String>();

        String[] inputArray = input.trim().split(" ");

        for (String s : inputArray) {
            if (!s.equals("") && input.length() >= 2) {
                searchWords.add(s);
            }
        }
        return searchWords;
    }

}

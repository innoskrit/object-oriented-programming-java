package in.innoskrit.exercises.library_management_system.model;

import java.util.List;

public class Patron {
    private String id;
    private String name;
    private List<Book> borrowedBooks;

    public Patron(String id, String name, List<Book> borrowedBooks) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = borrowedBooks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}

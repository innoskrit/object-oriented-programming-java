package in.innoskrit.exercises.library_management_system.service;

import in.innoskrit.exercises.library_management_system.constant.Constant;
import in.innoskrit.exercises.library_management_system.exception.PatronNotFoundException;
import in.innoskrit.exercises.library_management_system.model.Book;
import in.innoskrit.exercises.library_management_system.model.Patron;
import in.innoskrit.exercises.library_management_system.repository.PatronRepository;

import java.util.List;
import java.util.Map;

public class PatronService {
    private final PatronRepository patronRepository;
    private final BookService bookService;

    public PatronService(PatronRepository patronRepository, BookService bookService) {
        this.patronRepository = patronRepository;
        this.bookService = bookService;

    }

    public void addPatron(Patron patron) {
        patronRepository.addPatron(patron);
        System.out.println(Constant.PATRON_ADDED);
    }

    public void removePatron(String patronId) {
        try {
            patronRepository.removePatron(patronId);
            System.out.println(Constant.PATRON_REMOVED);
        } catch(PatronNotFoundException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public Patron getPatron(String patronId) {
        Patron patron = null;
        try {
            patron = patronRepository.getPatron(patronId);
        } catch(PatronNotFoundException exception) {
            System.err.println(exception.getMessage());
        }
        return patron;

    }
    public void borrowBook(String patronId, String bookId) {
        Patron patron = getPatron(patronId);
        Book book = bookService.getBook(bookId);
        if(patron != null && book != null && book.isAvailable()) {
            patron.getBorrowedBooks().add(book);
            book.setAvailable(false);
            System.out.println(Constant.BOOK_BORROWED_SUCCESS);
        } else {
            System.out.println(Constant.BOOK_BORROWED_FAILED);
        }
    }

    public void returnBook(String patronId, String bookId) {
        Patron patron = getPatron(patronId);
        Book book = bookService.getBook(bookId);
        if(patron != null && book != null) {
            book.setAvailable(true);
            System.out.println(Constant.BOOK_RETURN_SUCCESS);
        } else {
            System.out.println(Constant.BOOK_RETURN_FAILED);
        }
    }

    public List<Book> getBorrowedBooksByPatron(String patronId) {
        List<Book> borrowedBooks = null;
        try {
            borrowedBooks = patronRepository.getBorrowedBooksByPatron(patronId);
        } catch (PatronNotFoundException exception) {
            System.err.println(exception.getMessage());
        }
        return borrowedBooks;
    }
}


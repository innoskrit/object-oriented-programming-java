package in.innoskrit.exercises.library_management_system.service;

import in.innoskrit.exercises.library_management_system.constant.Constant;
import in.innoskrit.exercises.library_management_system.exception.BookNotFoundException;
import in.innoskrit.exercises.library_management_system.exception.UnauthorisedLibrarianException;
import in.innoskrit.exercises.library_management_system.model.Book;
import in.innoskrit.exercises.library_management_system.model.Librarian;
import in.innoskrit.exercises.library_management_system.repository.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;
    private final LibrarianService librarianService;

    public BookService(BookRepository bookRepository, LibrarianService librarianService) {
        this.bookRepository = bookRepository;
        this.librarianService = librarianService;
    }

    public void addBook(Book book, Librarian librarian) {
        try {
            if(librarianService.hasPermission(librarian.getId())) {
                bookRepository.addBook(book);
                System.out.println(Constant.BOOK_ADDED);
            }
        } catch (UnauthorisedLibrarianException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void removeBook(String bookId, Librarian librarian) {
        try {
            if(librarianService.hasPermission(librarian.getId())) {
                bookRepository.removeBook(bookId);
            }
        } catch(UnauthorisedLibrarianException | BookNotFoundException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public Book getBook(String bookId) {
        Book book = null;
        try {
            book = bookRepository.getBook(bookId);
        } catch(BookNotFoundException exception) {
            System.err.println(exception.getMessage());
        }
        return book;
    }

    public void updateBookAvailability(String bookId, boolean availability, Librarian librarian) {
        try {
            if(librarianService.hasPermission(librarian.getId())) {
                bookRepository.updateBookAvailability(bookId, availability);
            }
        } catch(UnauthorisedLibrarianException | BookNotFoundException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.getAvailableBooks();
    }

}

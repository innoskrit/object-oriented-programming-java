package in.innoskrit.exercises.library_management_system.repository;

import in.innoskrit.exercises.library_management_system.exception.BookNotFoundException;
import in.innoskrit.exercises.library_management_system.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void removeBook(String bookId) throws BookNotFoundException {
        if(!books.containsKey(bookId)) {
            throw new BookNotFoundException("Book not found with id : " + bookId);
        }
        books.remove(bookId);
    }

    public Book getBook(String bookId) throws BookNotFoundException {
        if(!books.containsKey(bookId)) {
            throw new BookNotFoundException("Book not found with id : " + bookId);
        }
        return books.get(bookId);
    }

    public void updateBookAvailability(String bookId, boolean availability) throws BookNotFoundException {
        if(!books.containsKey(bookId)) {
            throw new BookNotFoundException("Book not found with id : " + bookId);
        }
        books.get(bookId).setAvailable(availability);
    }

    public List<Book> getAvailableBooks() {
        List<Book> bookList = new ArrayList<>();
        for(Map.Entry<String, Book> bookEntry : books.entrySet()) {
            if(bookEntry.getValue().isAvailable())
                bookList.add(bookEntry.getValue());
        }
        return bookList;
    }
}


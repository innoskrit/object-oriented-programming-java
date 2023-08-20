package in.innoskrit.exercises.library_management_system;

import in.innoskrit.exercises.library_management_system.model.Book;
import in.innoskrit.exercises.library_management_system.model.Librarian;
import in.innoskrit.exercises.library_management_system.model.Patron;
import in.innoskrit.exercises.library_management_system.repository.BookRepository;
import in.innoskrit.exercises.library_management_system.repository.LibrarianRepository;
import in.innoskrit.exercises.library_management_system.repository.PatronRepository;
import in.innoskrit.exercises.library_management_system.service.BookService;
import in.innoskrit.exercises.library_management_system.service.LibrarianService;
import in.innoskrit.exercises.library_management_system.service.PatronService;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {

        // Creating services
        LibrarianService librarianService = new LibrarianService(new LibrarianRepository());
        BookService bookService = new BookService(new BookRepository(), librarianService);
        PatronService patronService = new PatronService(new PatronRepository(), bookService);


        // Add Librarian
        Librarian librarian1 = new Librarian("L1", "John", true);
        Librarian librarian2 = new Librarian("L2", "Sam", false);
        Librarian librarian3 = new Librarian("L3", "Sam", false);
        librarianService.addLibrarian(librarian1);
        librarianService.addLibrarian(librarian2);

        // Add Books
        Book book1 = new Book("B1", "OOPs in Java", "O-Reilly", true);
        Book book2 = new Book("B2", "Multithreading & Concurrency", "O-Reilly", true);
        bookService.addBook(book1, librarian1);
        bookService.addBook(book2, librarian1);

        System.out.println(bookService.getAvailableBooks());

        // Add Patron
        Patron patron1 = new Patron("P1", "Rick", new ArrayList<>());
        Patron patron2 = new Patron("P2", "Clark", new ArrayList<>());
        patronService.addPatron(patron1);
        patronService.addPatron(patron2);

        patronService.borrowBook("P1", "B1");
        patronService.borrowBook("P1", "B2");

        System.out.println(patronService.getBorrowedBooksByPatron("P1"));

        patronService.returnBook("P1", "B1");

        System.out.println(bookService.getAvailableBooks());

        patronService.borrowBook("P2", "B1");
        patronService.borrowBook("P2", "B2");

        System.out.println(bookService.getAvailableBooks());



    }


}

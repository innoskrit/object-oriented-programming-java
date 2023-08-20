package in.innoskrit.exercises.library_management_system.repository;

import in.innoskrit.exercises.library_management_system.exception.PatronNotFoundException;
import in.innoskrit.exercises.library_management_system.model.Book;
import in.innoskrit.exercises.library_management_system.model.Patron;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatronRepository {
    private final Map<String, Patron> patrons = new HashMap<>();

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public void removePatron(String patronId) throws PatronNotFoundException {
        if(!patrons.containsKey(patronId)) {
            throw new PatronNotFoundException("Patron not found with id : " + patronId);
        }
        patrons.remove(patronId);
    }

    public Patron getPatron(String patronId) throws PatronNotFoundException {
        if(!patrons.containsKey(patronId)) {
            throw new PatronNotFoundException("Librarian not found with id : " + patronId);
        }
        return patrons.get(patronId);
    }

    public List<Book> getBorrowedBooksByPatron(String patronId) {
        if(!patrons.containsKey(patronId)) {
            throw new PatronNotFoundException("Librarian not found with id : " + patronId);
        }
        return patrons.get(patronId).getBorrowedBooks();
    }
}


package in.innoskrit.exercises.library_management_system.repository;

import in.innoskrit.exercises.library_management_system.exception.LibrarianNotFoundException;
import in.innoskrit.exercises.library_management_system.exception.UnauthorisedLibrarianException;
import in.innoskrit.exercises.library_management_system.model.Librarian;

import java.util.HashMap;
import java.util.Map;

public class LibrarianRepository {
    private final Map<String, Librarian> librarians = new HashMap<>();

    public void addLibrarian(Librarian librarian) {
        librarians.put(librarian.getId(), librarian);
    }

    public void removeLibrarian(String librarianId) throws LibrarianNotFoundException {
        if(!librarians.containsKey(librarianId)) {
            throw new LibrarianNotFoundException("Librarian not found with id : " + librarianId);
        }
        librarians.remove(librarianId);
    }

    public Librarian getLibrarian(String librarianId) throws LibrarianNotFoundException {
        if(!librarians.containsKey(librarianId)) {
            throw new LibrarianNotFoundException("Librarian not found with id : " + librarianId);
        }
        return librarians.get(librarianId);
    }

    public boolean hasPermission(String librarianId) throws UnauthorisedLibrarianException {
        if(!librarians.containsKey(librarianId)) {
            throw new LibrarianNotFoundException("Librarian not found with id : " + librarianId);
        } else if(!librarians.get(librarianId).getIsAdmin()) {
            throw new UnauthorisedLibrarianException("Librarian does not have required permissions.");
        } else {
            return true;
        }
    }
}


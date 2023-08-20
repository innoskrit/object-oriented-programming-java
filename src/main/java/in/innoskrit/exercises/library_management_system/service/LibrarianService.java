package in.innoskrit.exercises.library_management_system.service;

import in.innoskrit.exercises.library_management_system.constant.Constant;
import in.innoskrit.exercises.library_management_system.exception.LibrarianNotFoundException;
import in.innoskrit.exercises.library_management_system.exception.UnauthorisedLibrarianException;
import in.innoskrit.exercises.library_management_system.model.Librarian;
import in.innoskrit.exercises.library_management_system.repository.LibrarianRepository;

public class LibrarianService {
    private final LibrarianRepository librarianRepository;
    public LibrarianService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    public void addLibrarian(Librarian librarian) {
        librarianRepository.addLibrarian(librarian);
        System.out.println(Constant.LIBRARIAN_ADDED);
    }

    public void removeLibrarian(String librarianId) {
        try {
            librarianRepository.removeLibrarian(librarianId);
            System.out.println(Constant.LIBRARIAN_REMOVED);
        } catch (LibrarianNotFoundException exception) {
            System.err.println(exception.getMessage());
        }

    }

    public Librarian getLibrarian(String librarianId) {
        Librarian librarian = null;
        try {
            librarian = librarianRepository.getLibrarian(librarianId);
        } catch (LibrarianNotFoundException exception) {
            System.err.println(exception.getMessage());
        }
        return librarian;
    }

    public boolean hasPermission(String librarianId) throws UnauthorisedLibrarianException {
        Librarian librarian = null;
        try {
            librarian = librarianRepository.getLibrarian(librarianId);
//            System.out.println(librarian.getIsAdmin() + librarian.getId());
            if(!librarian.getIsAdmin()) throw new UnauthorisedLibrarianException("Librarian does not have required permissions.");
            else return true;
        } catch (LibrarianNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }
}

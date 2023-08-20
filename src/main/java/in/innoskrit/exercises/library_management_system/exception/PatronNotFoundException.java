package in.innoskrit.exercises.library_management_system.exception;

public class PatronNotFoundException extends RuntimeException {
    public PatronNotFoundException(String message) {
        super(message);
    }
}

package course.errorAndExceptions.exceptions;

public class NoSuchFacultyInUniversityException extends Exception {
    public NoSuchFacultyInUniversityException() {
    }

    public NoSuchFacultyInUniversityException(String message) {
        super(message);
    }

    public NoSuchFacultyInUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchFacultyInUniversityException(Throwable cause) {
        super(cause);
    }
}

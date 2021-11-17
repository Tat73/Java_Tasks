package course.errorAndExceptions.exceptions;

public class NoSuchGroupsOnThatFacultyException extends Exception {
    public NoSuchGroupsOnThatFacultyException() {
    }

    public NoSuchGroupsOnThatFacultyException(String message) {
        super(message);
    }

    public NoSuchGroupsOnThatFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchGroupsOnThatFacultyException(Throwable cause) {
        super(cause);
    }
}

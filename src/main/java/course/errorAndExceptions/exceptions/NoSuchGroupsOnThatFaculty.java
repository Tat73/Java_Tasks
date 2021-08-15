package course.errorAndExceptions.exceptions;

public class NoSuchGroupsOnThatFaculty extends Exception {
    public NoSuchGroupsOnThatFaculty() {
    }

    public NoSuchGroupsOnThatFaculty(String message) {
        super(message);
    }

    public NoSuchGroupsOnThatFaculty(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchGroupsOnThatFaculty(Throwable cause) {
        super(cause);
    }
}

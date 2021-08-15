package course.errorAndExceptions.exceptions;

public class NoSuchSubjectException extends Exception {
    public NoSuchSubjectException() {
    }

    public NoSuchSubjectException(String message) {
        super(message);
    }

    public NoSuchSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchSubjectException(Throwable cause) {
        super(cause);
    }
}

package course.errorAndExceptions.exceptions;

public class NoSuchScoreException extends Exception {
    public NoSuchScoreException() {
    }

    public NoSuchScoreException(String message) {
        super(message);
    }

    public NoSuchScoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchScoreException(Throwable cause) {
        super(cause);
    }
}

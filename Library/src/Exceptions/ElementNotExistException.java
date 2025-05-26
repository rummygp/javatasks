package Exceptions;

public class ElementNotExistException extends RuntimeException {
    public ElementNotExistException(String message) {
        super(message);
    }
}

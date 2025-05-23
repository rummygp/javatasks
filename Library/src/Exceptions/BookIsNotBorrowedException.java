package Exceptions;

public class BookIsNotBorrowedException extends RuntimeException {
    public BookIsNotBorrowedException(String message) {
        super(message);
    }
}

package Elements;

import Exceptions.BookAlreadyBorrowedException;
import Exceptions.BookIsNotBorrowedException;

public abstract class LibraryItem {
    private final String title;
    private boolean borrowed;

    public LibraryItem(String title) {
        this.title = title;
        this.borrowed = false;
    }

    public abstract String toString();

    public void borrow() throws BookAlreadyBorrowedException {
        if (borrowed) {
            throw new BookAlreadyBorrowedException("Element " + title + " jest już wypożyczony.");
        }
        borrowed = true;
    }

    public void returnItem() {
        if (borrowed) {
            borrowed = false;
        } else {
            throw new BookIsNotBorrowedException(title + " Nie został wypożyczony.");
        }
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }
}


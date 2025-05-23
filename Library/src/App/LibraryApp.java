package App;

import Elements.LibraryItem;
import Exceptions.ElementNotExistException;
import Exceptions.ZeroAvailableElementException;
import Exceptions.ZeroBorrowedElementException;

import java.util.ArrayList;
import java.util.List;

public class LibraryApp {

    private final List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public List<LibraryItem> getItems(boolean isBorrowed) throws ZeroBorrowedElementException, ZeroAvailableElementException {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.isBorrowed() == isBorrowed) {
                result.add(item);
            }
        }
        if (result.isEmpty()) {
            if (isBorrowed) {
                throw new ZeroBorrowedElementException("Brak wypożyczonych elementów");
            } else {
                throw new ZeroAvailableElementException("Brak dostępnych elementów");
            }
        }
        return result;
    }

    public void borrowItem(String title) {
        LibraryItem item = findByTitle(title);
        item.borrow();
    }

    public void returnItem(String title) {
        LibraryItem item = findByTitle(title);
        item.returnItem();
    }

    public LibraryItem findByTitle(String title) throws ElementNotExistException {
        for (LibraryItem item : items) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        throw new ElementNotExistException("Nie znaleziono " + title + " w bibliotece");
    }
}
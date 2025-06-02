package App;

import Elements.LibraryItem;
import Exceptions.ZeroAvailableElementException;
import Exceptions.ZeroBorrowedElementException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class LibraryApp {

    private final List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public List<LibraryItem> getItems(boolean isBorrowed) {
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
        findByTitle(title).ifPresentOrElse(
                LibraryItem::borrow,
                () -> {
                    throw new NoSuchElementException("Nie ma takiego elementu");
                }
        );
    }

    public void returnItem(String title) {
        findByTitle(title).ifPresentOrElse(
                LibraryItem::returnItem,
                () -> {
                    throw new NoSuchElementException("Nie ma takiego elementu");
                }
        );
    }

    public Optional<LibraryItem> findByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equals(title)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }
}
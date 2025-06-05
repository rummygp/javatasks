package App;

import Elements.LibraryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryApp {

    private final List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public List<LibraryItem> getAvailableItems() {
        return items.stream()
                .filter(i -> !i.isBorrowed())
                .collect(Collectors.toList());
    }

    public List<LibraryItem> getBorrowedItems() {
        return items.stream()
                .filter(LibraryItem::isBorrowed)
                .collect(Collectors.toList());
    }

    public void borrowItem(String title) {
        LibraryItem item = findByTitle(title)
                .orElseThrow(() -> new NoSuchElementException("Nie ma takiego elementu"));
        item.borrow();
    }

    public void returnItem(String title) {
        LibraryItem item = findByTitle(title)
                .orElseThrow(() -> new NoSuchElementException("Nie ma takiego elementu"));
        item.returnItem();
    }

    public Optional<LibraryItem> findByTitle(String title) {
        return items.stream()
                .filter(items -> items.getTitle().equals(title))
                .findFirst();
    }
}

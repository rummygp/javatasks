import java.util.ArrayList;
import java.util.List;

public class LibraryApp {

    private List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public List<LibraryItem> getItems(boolean isBorrowed) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if(item.borrowed == isBorrowed) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean borrowItem (String title) {
        LibraryItem item = findByTitle(title);
        if (item != null) {
            return item.borrow();
        }
        return false;
    }
    public boolean returnItem (String title) {
        LibraryItem item = findByTitle(title);
        if (item != null) {
            return item.returnItem();
        }
        return false;
    }

    public LibraryItem findByTitle (String title) {
        for (LibraryItem item : items) {
            if (item.title.equals(title)) {
                return item;
            }
        }
        return null;
    }
}
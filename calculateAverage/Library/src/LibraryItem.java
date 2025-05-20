public abstract class LibraryItem {
    protected String title;
    protected boolean borrowed;

    public LibraryItem(String title) {
        this.title = title;
        this.borrowed = false;
    }

    public abstract String toString();


    public boolean borrow() {
        if (borrowed) {
            return false;
        }
        borrowed = true;
        return true;
    }

    public boolean returnItem() {
        if (borrowed) {
            borrowed = false;
            return true;

        }
        return false;
    }

}


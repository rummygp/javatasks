public class Book extends LibraryItem {
    private String author;
    private int pagesNumber;
    private static int bookCount = 0;

    public Book(String title, String author, int pagesNumber) {
        super(title);
        this.author = author;
        this.pagesNumber = pagesNumber;
        bookCount++;

    }

    @Override
    public String toString() {
        return "Książka: " + title + " | Autor: " + author + " | Strony: " + pagesNumber + "\n";

    }

    public static int getBookCount() {
        return bookCount;
    }
}

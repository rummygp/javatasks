package App;

import Elements.Book;
import Elements.Movie;
import Exceptions.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryApp libraryApp = new LibraryApp();
        Scanner scanner = new Scanner(System.in);

        libraryApp.addItem(new Book("Lalka", "Bolesław Prus", 500));
        libraryApp.addItem(new Book("Dziady", "Adam Mickiewicz", 343));
        libraryApp.addItem(new Movie("Titanic", "James Cameron", 222));
        libraryApp.addItem(new Movie("Incepcja", "Christopher Nolan", 123));

        boolean running = true;

        while (running) {
            System.out.println("\n   MENU");
            System.out.println("1. Wyświetl dostępne elementy");
            System.out.println("2. Wyświetl wypożyczone elementy");
            System.out.println("3. Wypożycz");
            System.out.println("4. Zwróć");
            System.out.println("5. Pokaż liczbę książek i filmów");
            System.out.println("6. Wyjście");
            System.out.print("Wybierz opcję: ");

            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "1":
                        System.out.println("\n Dostępne");
                        System.out.println(libraryApp.getAvailableItems());
                        break;
                    case "2":
                        System.out.println("\n Wypożyczone");
                        System.out.println(libraryApp.getBorrowedItems());
                        break;
                    case "3":
                        System.out.println("Podaj tytuł do wypożyczenia: ");
                        libraryApp.borrowItem(scanner.nextLine());
                        System.out.println("Wypożyczono");
                        break;
                    case "4":
                        System.out.println("Podaj tytuł do zwrotu: ");
                        libraryApp.returnItem(scanner.nextLine());
                        System.out.println("Zwrócono.");
                        break;
                    case "5":
                        System.out.println("Liczba książek: " + Book.getBookCount());
                        System.out.println("Liczba filmów: " + Movie.getMovieCount());
                        break;
                    case "6":
                        running = false;
                        System.out.println("Do widzenia!");
                        break;
                    default:
                        System.out.println("Podano niewłaściwą cyfrę.");
                }
            } catch (BookAlreadyBorrowedException | BookIsNotBorrowedException | NoSuchElementException e) {
                System.err.println("Błąd: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
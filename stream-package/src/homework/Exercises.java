package homework;

import homework.generator.HoldingGenerator;
import homework.model.*;
import homework.model.Currency;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Exercises {

    private static final List<Holding> holdings = new HoldingGenerator().generate();

    public static void main(String[] args) {
        System.out.println("getHoldingsWhereAreCompanies: " + getHoldingsWhereAreCompanies());
        System.out.println("getHoldingNames: " + getHoldingNames());
        System.out.println("getHoldingNamesAsString: " + getHoldingNamesAsString());
        System.out.println("getCompaniesAmount: " + getCompaniesAmount());
        System.out.println("getAllUserAmount " + getAllUserAmount());
        System.out.println("getAllCompaniesNamesAsLinkedList " + getAllCompaniesNamesAsLinkedList());
        Predicate<User> userNameStartsWithM = user -> user.getFirstName().charAt(0) == 'M';
        System.out.println("getUsersForPredicate by first letter of name - M " + getUsersForPredicate(userNameStartsWithM));
        Consumer<Company> printCompanyName = company -> System.out.print(company.getName() + ", ");
        System.out.print("executeForEachCompany print names: ");
        executeForEachCompany(printCompanyName);
        System.out.println();
        if (getRichestWoman().isPresent()) {
            System.out.println("getRichestWoman: " + getRichestWoman().get());
        }
        System.out.println("getFirstNCompany: " + getFirstNCompany(4));
        System.out.println("getUserPerCompany: " + getUserPerCompany());
        try {
            System.out.println(getUser(userNameStartsWithM));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println("createAccountMap: " + createAccountsMap());
        System.out.println("getUsersNames: " + getUserNames());
        System.out.println("showAllUsers: ");
        showAllUser();
        System.out.println("getCurenciesSet " + getCurenciesSet());
    }


    /**
     * Napisz metodę, która zwróci liczbę holdingów, w których jest przynajmniej jedna firma.
     */
    public static long getHoldingsWhereAreCompanies() {
        return holdings.stream()
                .filter(holding -> !holding.getCompanies().isEmpty())
                .count();
    }

    /**
     * Napisz metodę, która zwróci nazwy wszystkich holdingów pisane z wielkiej litery w formie listy.
     */
    public static List<String> getHoldingNames() {
        return holdings.stream()
                .map(holding -> holding.getName().toUpperCase())
                .collect(Collectors.toList());
    }

    /**
     * Zwraca nazwy wszystkich holdingów sklejone w jeden string i posortowane.
     * String ma postać: (Coca-Cola, Nestle, Pepsico)
     */
    public static String getHoldingNamesAsString() {
        return holdings.stream()
                .map(Holding::getName)
                .sorted()
                .collect(Collectors.joining(", ", "(", ")"));
    }

    /**
     * Zwraca liczbę firm we wszystkich holdingach.
     */
    public static long getCompaniesAmount() {
        return holdings.stream()
                .mapToLong(holding -> holding.getCompanies().size())
                .sum();
    }


    /**
     * Zwraca liczbę wszystkich pracowników we wszystkich firmach.
     */
    public static long getAllUserAmount() {
        return holdings.stream()
                .flatMap(h -> h.getCompanies().stream())
                .mapToLong(c -> c.getUsers().size())
                .sum();


    }

    /**
     * Zwraca listę wszystkich firm jako listę, której implementacja to LinkedList. Obiektów nie przepisujemy
     * po zakończeniu działania strumienia.
     */
    public static LinkedList<String> getAllCompaniesNamesAsLinkedList() {
        return holdings.stream()
                .flatMap(h -> h.getCompanies().stream())
                .map(Company::getName)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Zwraca imiona użytkowników w formie zbioru, którzy spełniają podany warunek.
     */
    public static Set<String> getUsersForPredicate(final Predicate<User> userPredicate) {
        return getUserStream()
                .filter(userPredicate)
                .map(User::getFirstName)
                .collect(Collectors.toSet());
    }

    /**
     * Dla każdej firmy uruchamia przekazaną metodę.
     */
    public static void executeForEachCompany(Consumer<Company> consumer) {
        getCompanyStream().forEach(consumer);
    }

    /**
     * Przelicza kwotę na rachunku na złotówki za pomocą kursu określonego w enum Currency.
     */
    public static BigDecimal getAccountAmountInPLN(Account account) {
        return account
                .getAmount()
                .multiply(BigDecimal.valueOf(account.getCurrency().rate))
                .round(new MathContext(4, RoundingMode.HALF_UP));
    }

    /**
     * Wyszukuje najbogatsza kobietę i zwraca ją. Metoda musi uzwględniać to że rachunki są w różnych walutach.
     */
    //pomoc w rozwiązaniu problemu w zadaniu: https://stackoverflow.com/a/55052733/9360524
    public static Optional<User> getRichestWoman() {
        return getUserStream()
                .filter(u -> u.getSex() == Sex.WOMAN)
                .max(Comparator.comparing(Exercises::getEmployeeAmountInPLN));
    }

    public static BigDecimal getEmployeeAmountInPLN(final User user) {
        return user.getAccounts()
                .stream()
                .map(Exercises::getAccountAmountInPLN)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Zwraca nazwy pierwszych N firm. Kolejność nie ma znaczenia.
     */
    private static Set<String> getFirstNCompany(final int n) {
        return getCompanyStream()
                .map(Company::getName)
                .limit(n)
                .collect(Collectors.toSet());


    }

    /**
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników.
     */
    public static Map<String, List<User>> getUserPerCompany() {
        return getCompanyStream()
                .collect(Collectors.toMap(Company::getName, Company::getUsers));
    }

    /**
     * Zwraca pierwszego z brzegu użytkownika dla podanego warunku. W przypadku kiedy nie znajdzie użytkownika, wyrzuca
     * wyjątek IllegalArgumentException.
     */
    public static User getUser(final Predicate<User> predicate) {
        return getUserStream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono użytkownika dla tego warunku"));
    }

    /**
     * Zwraca mapę rachunków, gdzie kluczem jest numer rachunku, a wartością ten rachunek.
     */
    public static Map<String, Account> createAccountsMap() {
        return getAccoutStream()
                .collect(Collectors.toMap(Account::getNumber, account -> account));
    }

    /**
     * Zwraca listę wszystkich imion w postaci Stringa, gdzie imiona oddzielone są spacją i nie zawierają powtórzeń.
     */
    public static String getUserNames() {
        return getUserStream()
                .map(User::getFirstName)
                .distinct()
                .collect(Collectors.joining(" "));
    }

    /**
     * Metoda wypisuje na ekranie wszystkich użytkowników (imię, nazwisko) posortowanych od z do a.
     * Zosia Psikuta, Zenon Kucowski, Zenek Jawowy ... Alfred Pasibrzuch, Adam Wojcik
     */
    public static void showAllUser() {
        getUserStream()
                .map(user -> user.getFirstName() + " " + user.getLastName())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    /**
     * Zwraca zbiór walut w jakich są rachunki.
     */
    public static Set<Currency> getCurenciesSet() {
        return getAccoutStream()
                .map(Account::getCurrency)
                .collect(Collectors.toSet());
    }

    /**
     * Zwraca strumień wszystkich firm.
     */
    private static Stream<Company> getCompanyStream() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream());
    }

    /**
     * Tworzy strumień użytkowników.
     */
    private static Stream<User> getUserStream() {
        return getCompanyStream()
                .flatMap(company -> company.getUsers().stream());
    }

    /**
     * Tworzy strumień rachunków.
     */
    private static Stream<Account> getAccoutStream() {
        return getUserStream()
                .flatMap(user -> user.getAccounts().stream());
    }

}

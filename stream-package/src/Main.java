import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<Product> products = DataStorage.getProducts();
    public static List<Order> orders = DataStorage.getOrders();

    public static void main(String[] args) {
        // Zadania
        //1. Produkty zamawiane przez więcej niż 3 różnych klientów
        //
        //Zwróć listę nazw produktów (List<String>), które zostały zamówione przez więcej niż trzech unikalnych klientów.
        //2. Suma wydatków każdego klienta
        //
        //Zwróć Map<String, BigDecimal> – dla każdego klienta oblicz sumę wydatków na podstawie liczby sztuk i ceny produktu.
        //3. Dla każdej kategorii podaj zestaw regionów, w których była zamawiana
        //
        //Zwróć Map<String, Set<String>>, gdzie kluczem jest kategoria (Product.category), a wartością zestaw regionów, w których złożono zamówienia na produkty z tej kategorii.
        //4. Najdroższy produkt zamówiony ogółem
        //
        //Zwróć pojedynczy obiekt Product, który był najdroższy spośród tych, które faktycznie zostały zamówione (czyli znajdują się w Order).
        //5. Czy w każdym regionie zamawiano coś z kategorii "Electronics"?
        //
        //Zwróć Map<String, Boolean>, gdzie kluczem jest region, a wartością true jeśli w tym regionie zamówiono jakikolwiek produkt z kategorii "Electronics".
        //
        //podpowiastka uzyć gdzieś trzeba Collectors.reducing
        System.out.println("Zadanie 1: " + getPopularProduct());
        System.out.println("Zadanie 2: " + calculateTotalSpentPerClient());
        System.out.println("Zadanie 3: " + getRegionsByCategory());
        System.out.println("Zadanie 4: " + getMostExpensiveOrderedProduct());

    }

    public static Stream<Order> getOrdersStream() {
        return orders.stream();
    }

    public static Stream<Product> getProductStream() {
        return products.stream();
    }

    public static List<String> getPopularProduct() {
        return getOrdersStream()
                .collect(Collectors.groupingBy(
                        Order::getProductName,
                        Collectors.mapping(Order::getClientName, Collectors.toSet())))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, BigDecimal> calculateTotalSpentPerClient() {
        return getOrdersStream()
                .collect(Collectors.groupingBy(
                        Order::getClientName,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                order -> {
                                    Product product = getProductStream()
                                            .filter(product1 -> product1.getName().equals(order.getProductName()))
                                            .findFirst()
                                            .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono produktu: " +
                                                    order.getProductName()));
                                    return product.getPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
                                },
                                BigDecimal::add
                        )
                ));
    }

    public static Map<String, Set<String>> getRegionsByCategory() {
        return getOrdersStream()
                .collect(Collectors.groupingBy(
                        order -> getProductStream()
                                .filter(product -> product.getName().equals(order.getProductName()))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono produktu " +
                                        order.getProductName()))
                                .getCategory(),
                        Collectors.mapping(Order::getRegion, Collectors.toSet())
                ));
    }

    public static Product getMostExpensiveOrderedProduct () {
        return getOrdersStream()
                .map(Order::getProductName)
                .distinct()
                .map(productName -> getProductStream()
                        .filter(product -> product.getName().equals(productName))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Brak produktu: " + productName)))
                .max(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new IllegalArgumentException("Brak zamówionych produktów"));
    }
}

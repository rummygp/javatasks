import java.math.BigDecimal;
import java.util.List;

    public class DataStorage {
        public static List<Product> getProducts() {
            return List.of(
                    new Product("Laptop", "Electronics", new BigDecimal("3000.00")),
                    new Product("Smartphone", "Electronics", new BigDecimal("2000.00")),
                    new Product("Chair", "Furniture", new BigDecimal("300.00")),
                    new Product("Desk", "Furniture", new BigDecimal("700.00")),
                    new Product("Headphones", "Electronics", new BigDecimal("500.00"))
            );
        }

        public static List<Order> getOrders() {
            return List.of(
                    new Order("Alice", "Laptop", 1, "North"),
                    new Order("Adam", "Headphones", 2, "East"),
                    new Order("Alice", "Headphones", 4, "North"),
                    new Order("Charlie", "Desk", 1, "South"),
                    new Order("David", "Laptop", 1, "East"),
                    new Order("Eve", "Laptop", 1, "West"),
                    new Order("Frank", "Laptop", 1, "South"),
                    new Order("Ann", "Headphones", 2, "North"),
                    new Order("Bob", "Headphones", 1, "West")
            );
        }
    }


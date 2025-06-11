import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Shop {
    public static void main(String[] args) {
        final int maxQueueSize = 5;
        final int totalItems = 30;
        final int producersNumber = 2;
        final int customerNumber = 4;

        Config queue = new Config(maxQueueSize);

        try (ExecutorService prodExecutor = Executors.newFixedThreadPool(producersNumber);
             ExecutorService customerExecutor = Executors.newFixedThreadPool(customerNumber)) {

            for (int i = 0; i < totalItems; i++) {
                Producer producer = new Producer(queue);
                Customer customer = new Customer(queue);
                prodExecutor.execute(producer);
                customerExecutor.execute(customer);
            }
        }
        System.out.println("Sklep zamknięty");
    }
}

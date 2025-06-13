import static java.lang.Thread.sleep;

public class Customer implements Runnable {
    private final Config queue;

    public Customer(Config queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Integer value = queue.consume();
            System.out.println("Konsument " + Thread.currentThread().getName() + " skonsumował: " + value);
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

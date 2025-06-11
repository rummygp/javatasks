import java.util.Random;

import static java.lang.Thread.sleep;

public class Producer implements Runnable {
    private final Config queue;
    private static int itemCounter = 0;

    public Producer(Config queue) {
        this.queue = queue;
    }

    Random random = new Random();

    @Override
    public void run() {
        try {
            sleep(random.nextInt(3000));
            queue.produce(itemCounter);
            System.out.println("Producent " + Thread.currentThread().getName() + " wyprodukował: " + itemCounter);
            itemCounter++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

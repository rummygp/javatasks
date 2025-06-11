import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Config {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;
    private final Lock lock = new ReentrantLock();
    private final Condition isFull = lock.newCondition();
    private final Condition isEmpty = lock.newCondition();

    public Config(int capacity) {
        this.capacity = capacity;
    }

    public void produce (Integer value) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= capacity) {
                isFull.await();
            }
            queue.add(value);
            System.out.println("Dodane do kolejki: " + value + " | Ilość elementów w kolejce: " + queue.size());
            isEmpty.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public Integer consume() throws InterruptedException {
        lock.lock();
        try{
            while(queue.isEmpty()) {
                isEmpty.await();
            }
            int value = queue.poll();
            System.out.println("Pobrano z kolejki " + value + " | Ilość elemntów w kolejce: " + queue.size());
            isFull.signalAll();
            return value;
        }
        finally {
            lock.unlock();
        }
    }
}

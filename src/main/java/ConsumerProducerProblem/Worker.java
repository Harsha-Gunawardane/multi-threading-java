package ConsumerProducerProblem;

import java.util.ArrayList;
import java.util.List;

public class Worker implements WorkerInterface {

    private int current = 0;
    private final List<Integer> container = new ArrayList<>();

    @Override
    public void produce() throws InterruptedException {
        while (true) {
            synchronized (LOCK) {
                if (container.size() == MAX) {
                    System.out.println("Container is full! Waiting for consumer ...");
                    LOCK.wait(); // Release the lock and wait
                }
                System.out.println((current + 1) + " Item is added to the container");
                container.add(current++);
                LOCK.notify(); // Notify waiting threads
            }
            Thread.sleep(800); // Simulate production time outside the lock
        }
    }

    @Override
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (LOCK) {
                if (container.isEmpty()) {
                    System.out.println("Container is empty! Waiting for producer ...");
                    LOCK.wait(); // Release the lock and wait
                }
                int item = container.remove(container.size() - 1);
                System.out.println("Item " + item + " is removed from the container");
                LOCK.notify(); // Notify waiting threads
            }
            Thread.sleep(500); // Simulate consumption time outside the lock
        }
    }
}

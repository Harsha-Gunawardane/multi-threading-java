package conditionOnLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionOnLockApplication {

    private static final Integer MAX_SIZE = 5;
    private static final Lock lock = new ReentrantLock();
    private static final Condition bufferNotFull = lock.newCondition();
    private static final Condition bufferNotEmpty = lock.newCondition();
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Thread producerThread = new Thread(() -> {
           for (int i = 0; i < 10; i++) {
               try {
                   produce(i);
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        Thread consumerThread = new Thread(() -> {
           for (int i = 0; i < 10; i++) {
               try {
                   consume();
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        producerThread.start();
        consumerThread.start();
    }

    private static void produce(int item) throws InterruptedException {
        lock.lock();

        try {
            while (queue.size() == MAX_SIZE) {
                System.out.println("Queue is full");
                bufferNotFull.await();
            }

            queue.offer(item);
            System.out.println("Produced: " + item);
            bufferNotEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    private static void consume() throws InterruptedException {
        lock.lock();

        try {
            while (queue.isEmpty()) {
                System.out.println("Queue is empty");
                bufferNotEmpty.await();
            }

            System.out.println("Consumed: " + queue.poll());
            bufferNotFull.signal();
        } finally {
            lock.unlock();
        }
    }
}

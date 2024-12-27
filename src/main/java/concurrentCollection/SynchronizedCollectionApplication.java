package concurrentCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedCollectionApplication {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println(list.size());

//        blockingQueueTest();
        concurrentMapTest();
    }

    static final int QUEUE_CAPACITY = 10;
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    private static void blockingQueueTest() {

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    queue.put(i);
                    System.out.println("[PRODUCED] - [Task " + i + "]");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int task = queue.take();
                    process(task, "Harsha");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                while (true) {
                    int task = queue.take();
                    process(task, "Lahiru");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
        consumer2.start();
    }

    private static void process(int task, String consumer) throws InterruptedException {
        System.out.println("[PROCESSING] - [" + task + "] - by " + consumer);
        Thread.sleep(1000);
        System.out.println("[PROCESSED] - [" + task + "] - by " + consumer);
    }

    // concurrent hash map
    private static final Map<String, String> cache = new ConcurrentHashMap<>();

    private static void concurrentMapTest() {

        for (int i = 0; i < 10; i++) {
            final int threadId = i;

            new Thread(() -> {
                String key = "Key-" + threadId;

                for (int j = 0; j < 3; j++) {
                    String value = getCacheValue(key);
                    System.out.println("Thread " + Thread.currentThread().getName() + " : Key " + key + " : value : " + value);
                }
            }).start();
        }
    }

    private static String getCacheValue(String key) {
        String value = cache.get(key);

        if (value == null) {
            value = compute(key);
            cache.put(key, value);
        }
        return value;
    }

    private static String compute(String key) {
        System.out.println(key + " not present in the cache, So compute the value");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Value for " + key;
    }
}

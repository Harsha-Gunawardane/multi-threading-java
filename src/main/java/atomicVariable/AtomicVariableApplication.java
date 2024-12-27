package atomicVariable;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableApplication {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(counter);
    }
}

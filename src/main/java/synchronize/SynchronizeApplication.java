package synchronize;

public class SynchronizeApplication {

    private static int counter1 = 0;
    private static int counter2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment1();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment2();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("[COUNTER 1] : " + counter1 + ";[COUNTER 2] : " + counter2);
    }

    private static void increment1() {

        // block level synchronization
        synchronized (lock1) {
            counter1++;
        }
    }

    private static void increment2() {
        synchronized (lock2) {
            counter2++;
        }
    }
}

package waitAndNotify;

public class WaitAndNotifyApplication {

    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread threadOne = new Thread(() -> {
            try {
                taskOne();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadTwo = new Thread(() -> {
            try {
                taskTwo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadOne.start();
        threadTwo.start();
    }

    private static void taskOne() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Task One is waiting for lock ...");
            lock.wait();
            System.out.println("Lock is back to task one ...");
        }
    }

    private static void taskTwo() throws InterruptedException {
        synchronized (lock) {
            Thread.sleep(3000);
            System.out.println("Task Two is starting ...");
            lock.notify();
            System.out.println("Task Two is notifying ...");
        }
    }
}

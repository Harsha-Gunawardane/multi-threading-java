package multiThreading.thread.runnableInterface;

public class UserThread implements Runnable {

    @Override
    public void run() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("User thread is running");
    }
}

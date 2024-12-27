package multiThreading.thread.runnableInterface;

public class ThreadTwo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("[THREAD 2] : " + i);
        }
    }
}

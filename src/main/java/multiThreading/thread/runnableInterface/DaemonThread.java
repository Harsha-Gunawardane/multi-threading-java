package multiThreading.thread.runnableInterface;

public class DaemonThread implements Runnable{

    @Override
    public void run() {
        int counter = 0;
        while (counter < 100) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
            System.out.println("Daemon is running -> " + counter);
        }
    }
}

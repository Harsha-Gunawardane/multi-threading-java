package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockApplication {

    private final Lock lockA = new ReentrantLock(true);
    private final Lock lockB = new ReentrantLock(true);

    public static void main(String[] args) {

        DeadLockApplication app = new DeadLockApplication();
        new Thread(app::workerOne, "Worker One").start();
        new Thread(app::workerTwo, "Worker Two").start();

        new Thread(() -> {
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

            while (true) {
                long[] threadIds = threadMXBean.findDeadlockedThreads();
                if (threadIds != null) {
                    System.out.println(threadIds.length + " no of threads are in deadlock");
                    for (long threadId : threadIds) {
                        System.out.println(threadId + " thread is in deadlock");
                    }
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public void workerOne() {
        lockA.lock();
        System.out.println("Worker one acquired lock A");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lockB.lock();
        System.out.println("Worker one acquired lock B");
        lockA.unlock();
        lockB.unlock();
    }

    public void workerTwo() {
        lockB.lock();
        System.out.println("Worker two acquired lock B");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lockA.lock();
        System.out.println("Worker two acquired lock A");
        lockB.unlock();
        lockA.unlock();
    }
}

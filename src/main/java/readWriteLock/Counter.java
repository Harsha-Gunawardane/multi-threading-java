package readWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {

    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        lock.writeLock().lock();

        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " writes : " + count);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void read() {
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " reads : " + count);
        } finally {
            lock.readLock().unlock();
        }
    }
}

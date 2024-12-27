package multiThreading;

import multiThreading.thread.runnableInterface.DaemonThread;
import multiThreading.thread.runnableInterface.ThreadOne;
import multiThreading.thread.runnableInterface.ThreadTwo;
import multiThreading.thread.runnableInterface.UserThread;
import multiThreading.thread.threadClass.ThreadFour;
import multiThreading.thread.threadClass.ThreadThree;

public class RunnableApplication {

    public static void main(String[] args) throws InterruptedException {

        // threads that created from runnable approach
        // these two threads are in new state
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());

        // create thread using lambda functions
//        Thread threadThree = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("[THREAD 3] : " + i);
//            }
//        });

        // threads that created from Thread class extend approach
        Thread threadThree = new ThreadThree();
        Thread threadFour = new ThreadFour();

        // now threads are in active state. either running or runnable depending on the CPU availability
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

        // join all threads before print "Execution Done" message
        threadOne.join();
        threadTwo.join();
        threadThree.join();
        threadFour.join();
        System.out.println("Execution Done");

        testDaemonThread();
        testThreadPriority();
        testSynchronization();
    }

    private static void testDaemonThread() {
        Thread daemonThread = new Thread(new DaemonThread());
        // turn the thread as daemon thread
        daemonThread.setDaemon(true);

        Thread userThread = new Thread(new UserThread());

        daemonThread.start();
        userThread.start();
    }

    private static void testThreadPriority() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());
    }

    private static int counter = 0;
    private static void testSynchronization() throws InterruptedException {

        Thread threadOne = new Thread(() -> {
           for (int i = 0; i < 10000; i++) {
               increment();
           }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println(counter);
    }

    // method level synchronization
    // this is not recommended
    // it is oky to use with very few lines of code in method
    private synchronized static void increment() {
        counter++;
    }
}

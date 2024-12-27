package threadPool;

import threadPool.cpuIntensive.CPUTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolApplication {

    public static void main(String[] args) {

//        singleThreadExecutorRun();
//        fixedThreadPoolRun();
//        cachedThreadPoolRun();
//        ScheduledThreadExecutorRun();
        cpuIntensiveTask();

    }

    private static void singleThreadExecutorRun() {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            service.execute(new Task(i));
        }
    }

    private static void fixedThreadPoolRun() {
        ExecutorService service = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 20; i++) {
            service.execute(new Task(i));
        }
    }

    private static void cachedThreadPoolRun() {
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            service.execute(new Task(i));
        }
    }

    private static void ScheduledThreadExecutorRun() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(8);
        service.scheduleAtFixedRate(new Task(1), 1000, 2000, TimeUnit.MILLISECONDS);

        try {
            if (service.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }

        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }

    private static void cpuIntensiveTask() {

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(cores);
        System.out.println("Created thread pool with " + cores + " cores");

        for (int i = 0; i < 20; i++) {
            service.execute(new CPUTask());
        }
    }
}

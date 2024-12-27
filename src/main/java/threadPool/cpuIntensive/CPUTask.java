package threadPool.cpuIntensive;

public class CPUTask implements Runnable{

    @Override
    public void run() {
        System.out.println("CPU task started by " + Thread.currentThread().getName());
    }
}

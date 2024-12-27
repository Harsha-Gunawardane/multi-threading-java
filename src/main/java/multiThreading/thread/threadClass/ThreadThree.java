package multiThreading.thread.threadClass;

public class ThreadThree extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("[THREAD 3 : ]" + i);
        }
    }
}

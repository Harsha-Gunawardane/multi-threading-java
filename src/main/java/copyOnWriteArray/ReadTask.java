package copyOnWriteArray;

import java.util.List;

public class ReadTask implements Runnable {

    private final List<Integer> list;

    public ReadTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Reading the list : " + list);
        }
    }
}

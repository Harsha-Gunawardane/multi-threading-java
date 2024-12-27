package copyOnWriteArray;

import java.util.List;
import java.util.Random;

public class WriteTask implements Runnable {

    private final List<Integer> list;
    private Random random;

    public WriteTask(List<Integer> list) {
        this.list = list;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Updating the list ...");
            list.set(random.nextInt(list.size()), random.nextInt(100));
        }
    }
}

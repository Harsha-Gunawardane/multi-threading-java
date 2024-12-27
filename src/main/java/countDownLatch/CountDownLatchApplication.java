package countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchApplication {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        new Thread(new Chef("Chef 1", "Fish", latch)).start();
        new Thread(new Chef("Chef 2", "Chicken", latch)).start();
        new Thread(new Chef("Chef 3", "Mutton", latch)).start();

        latch.await();

        System.out.println("All dishes are finished !");
    }
}

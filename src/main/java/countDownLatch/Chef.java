package countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Chef implements Runnable {

    private final String chefName;
    private final String dish;
    private final CountDownLatch countDownLatch;

    public Chef(String chefName, String dish, CountDownLatch countDownLatch) {
        this.chefName = chefName;
        this.dish = dish;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(chefName + " is starting to make the " + dish);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(chefName + " is finished making the " + dish);
        countDownLatch.countDown();
    }
}

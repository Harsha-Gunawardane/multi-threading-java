package cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Tour {

    private static final int NO_OF_TOURISTS = 5;
    private static final int NO_OF_LOCATIONS = 3;

    private static final CyclicBarrier barrier = new CyclicBarrier(NO_OF_TOURISTS, () -> {
        System.out.println("Guide man is giving instructions ...");
    });

    public static void main(String[] args) {

        for (int i = 0; i < NO_OF_TOURISTS; i++) {
            Thread tourist = new Thread(new Tuorist(i));
            tourist.start();
        }
    }

    // create an inner class
    private static class Tuorist implements Runnable {

        private final int tuoristId;

        private Tuorist(int tuoristId) {
            this.tuoristId = tuoristId;
        }

        @Override
        public void run() {

            for (int i = 0; i < NO_OF_LOCATIONS; i++) {
                System.out.println(tuoristId + " is going tour location " + (i + 1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(tuoristId + " is completed tour location " + (i + 1));

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

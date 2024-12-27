package exchanger;

import java.util.concurrent.Exchanger;

public class FirstThread implements Runnable {

    private final Exchanger<Integer> exchanger;

    public FirstThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int dataToSend = 100;
        System.out.println("First thread is sending: " + dataToSend);

        try {
            Integer receivedData = exchanger.exchange(dataToSend);
            System.out.println("First thread received: " + receivedData);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

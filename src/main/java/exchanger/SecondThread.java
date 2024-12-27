package exchanger;

import java.util.concurrent.Exchanger;

public class SecondThread implements Runnable {

    private final Exchanger<Integer> exchanger;

    public SecondThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int dataToSend = 500;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Second thread is sending: " + dataToSend);

        try {
            Integer receivedData = exchanger.exchange(dataToSend);
            System.out.println("Second thread received: " + receivedData);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

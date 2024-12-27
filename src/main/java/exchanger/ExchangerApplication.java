package exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerApplication {

    public static void main(String[] args) {

        Exchanger<Integer> exchanger = new Exchanger<>();

        Thread threadOne = new Thread(new FirstThread(exchanger));
        Thread threadTwo = new Thread(new SecondThread(exchanger));

        threadOne.start();
        threadTwo.start();
    }
}

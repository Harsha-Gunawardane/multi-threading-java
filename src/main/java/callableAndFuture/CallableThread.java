package callableAndFuture;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 0;
    }
}

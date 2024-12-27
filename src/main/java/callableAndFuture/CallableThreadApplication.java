package callableAndFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThreadApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> result = service.submit(new CallableThread());

        System.out.println(result.get());
        System.out.println("Main thread execution is completed");
    }
}

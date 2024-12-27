package copyOnWriteArray;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWAApplication {

    public static void main(String[] args) {

        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0));

        new Thread(new WriteTask(list)).start();
        new Thread(new WriteTask(list)).start();
        new Thread(new WriteTask(list)).start();
        new Thread(new ReadTask(list)).start();
    }
}

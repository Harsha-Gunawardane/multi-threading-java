package readWriteLock;

public class ReadWriteApplication {

    public static void main(String[] args) {

        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            Thread reader = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    counter.read();
                }
            });
            reader.setName("[READER]" + i);
            reader.start();
        }

        Thread writer = new Thread(() -> {
           for (int j = 0; j < 5; j++) {
               counter.write();
           }
        });
        writer.setName("[WRITER]");
        writer.start();
    }
}

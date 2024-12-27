package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreApplication {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            service.execute(Scraper.INSTANCE::scrape);
        }
    }
}

// singleton class
enum Scraper {
    INSTANCE;

    private final Semaphore semaphore = new Semaphore(3);

    public void scrape() {
        try {
            semaphore.acquire();
            invokeBot();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    private void invokeBot() throws InterruptedException {
        System.out.println("Scraping the web site...");
        Thread.sleep(1000);
    }
}

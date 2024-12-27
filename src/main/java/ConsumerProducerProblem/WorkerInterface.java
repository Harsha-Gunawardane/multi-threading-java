package ConsumerProducerProblem;

public interface WorkerInterface {

    Object LOCK = new Object();
    int MAX = 10;

    void produce() throws InterruptedException;
    void consume() throws InterruptedException;
}

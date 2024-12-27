package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class WorkLoadSplitter extends RecursiveAction {

    int workload;

    public WorkLoadSplitter(int workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {

        if (workload > 10) {
            System.out.println(workload + " works are too much. So split.");
            int workload1 = workload / 2;
            int workload2 = workload - workload1;

            WorkLoadSplitter splitter1 = new WorkLoadSplitter(workload1);
            WorkLoadSplitter splitter2 = new WorkLoadSplitter(workload2);

            splitter1.fork();
            splitter2.fork();
        } else {
            process(workload);
        }
    }

    private void process(int workload) {
        System.out.println("Workload: " + workload + " is processing...");
    }
}

class WorkLoadSplitterApplication {

    public static void main(String[] args) {
        int workload = 16;

        WorkLoadSplitter splitter = new WorkLoadSplitter(workload);
        ForkJoinPool pool = new ForkJoinPool(4);

        pool.invoke(splitter);
    }
}

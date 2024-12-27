package forkJoin;

import java.util.concurrent.RecursiveTask;

public class AdditionTask extends RecursiveTask<Integer> {

    int start;
    int end;
    int[] array;

    public AdditionTask(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    protected Integer compute() {

        // this condition is for recursion condition
        int size = end - start + 1;
        if (size > 10) {
            int mid = (start + end) / 2;

            AdditionTask task1 = new AdditionTask(start, mid, array);
            AdditionTask task2 = new AdditionTask(mid + 1, end, array);

            task1.fork();
            task2.fork();

            return task1.join() + task2.join();
        } else {
            return add();
        }
    }

    private Integer add() {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }
}

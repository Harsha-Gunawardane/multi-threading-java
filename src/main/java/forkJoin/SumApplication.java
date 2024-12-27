package forkJoin;

import java.util.concurrent.ForkJoinPool;

public class SumApplication {

    public static void main(String[] args) {

        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;

        ForkJoinPool pool = new ForkJoinPool(4);

        AdditionTask task = new AdditionTask(0, arr.length - 1, arr);
        Integer res = pool.invoke(task);

        System.out.println("Result: " + res);
    }
}

package forkJoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinApplication {

    public static void main(String[] args) {

        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        int searchElement = random.nextInt(100);

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        System.out.println("Search element: " + searchElement);
        SearchTask task = new SearchTask(arr, 0, arr.length - 1, searchElement);

        Integer result = forkJoinPool.invoke(task);
        System.out.println("Search result: " + result);
    }
}

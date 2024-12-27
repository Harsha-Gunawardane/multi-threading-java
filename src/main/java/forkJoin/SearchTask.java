package forkJoin;

import java.util.concurrent.RecursiveTask;

public class SearchTask extends RecursiveTask<Integer> {

    int[] array;
    int start;
    int end;
    int searchElement;

    public SearchTask(int[] array, int start, int end, int searchElement) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.searchElement = searchElement;
    }

    @Override
    protected Integer compute() {

        int size = end - start + 1;
        if (size > 50) {
            int mid = (start + end) / 2;
            SearchTask searchTask1 = new SearchTask(array, start, mid, searchElement);
            SearchTask searchTask2 = new SearchTask(array, mid + 1, end, searchElement);

            searchTask1.fork();
            searchTask2.fork();

            return searchTask1.join() + searchTask2.join();
        } else {
            return search();
        }
    }

    private Integer search() {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (array[i] == searchElement) {
                count++;
            }
        }
        return count;
    }
}

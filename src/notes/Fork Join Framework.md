# Fork Join Framework

This is also similar to executor service with some additional functionalities.

#### Differences from ExecutorService.
* Task can produce sub-task
* Work stealing
* Per thread queueing

Work stealing is, an idle thread can get sub-task from busy thread.

### Key concepts in Fork Join Framework
* Forking - dividing large task to sub-tasks.
* Joining - Waiting for completion of tasks
* RecursiveTask - it recursively return a task by ```fork()``` method. This return a value. This is quite similar to 
```Callable``` interface.
* RecursiveAction - This is similar to ```Runnable``` interface. Nothing return from this.

## Fork Join Pool

* Work stealing algorithm - used to distribute tasks efficiently among all threads.
* Parallelism
* For & Join operations

```ForkJoinPool forkJoinPool = new ForkJoinPool();```
This is how we can create fork join pool. If we not pass the no of processes, it by default figure it out how parallelism is needed.


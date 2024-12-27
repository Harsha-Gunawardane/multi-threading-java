# Thread Priority

### Thread Scheduler
* Thread scheduler decides which thread execute on the CPU among runnable threads.
* Each thread got a priority from 0 to 10. [0 is  ```MIN_PRIORITY```]
* Under normal circumstance, the thread with higher priority gets to run on CPU.
* Priority 5 is called as ```NORM_PRIORITY``` indicates ```NORMAL PRIORITY```
* Threads with same priority are executed in ```FIFO``` manner.
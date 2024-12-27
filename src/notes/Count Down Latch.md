# Countdown Latch

This is a countdown for waiting until required no of threads are completed.

Think initial countdown value is 3. After finishing every thread ```latch.countdown()``` method is called.
after latch is got 0, then main thread can continue the execution, otherwise ```latch.await()``` function keep waiting the main thread until required no of threads are completed.

Countdown latch is more similar to ```join()``` method. But it is cleaner.
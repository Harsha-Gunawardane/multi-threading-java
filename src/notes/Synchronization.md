# Synchronization

* When two tasks use a shared resource, it should be mutual exclusive. Otherwise, the result not be expected one.
* In such cases we can use ```synchronized``` keyword to ensure the mutual exclusive. There are two levels to use it.

i. Method level

```
    private synchronized static void increment() {
        counter++;
    }
```

ii. Block level

```
    private static void increment1() {

        // block level synchronization
        synchronized (lock1) {
            counter1++;
        }
    }
```

* Method level synchronization is not recommended under certain reasons.
    
    i.  Synchronizing at the method level locks the entire method, even if synchronization is only needed for a small portion of the code.
    
    ii. When multiple synchronized methods are called in a nested manner or involve multiple locks, there is a potential for deadlocks if not managed carefully.

    iii. A static synchronized method locks the class object (Class<?>), affecting all threads trying to access static synchronized methods of that class.

## Wait & Notify

with ```wait()``` the thread is being waiting until notify to execute.
 Another thread is notify using ```notify()``` method. 

This ```notify()``` is for notifying for one thread. For notifying all waiting threads we can use 
```notifyAll()``` method.

Eg :

```
public class WaitAndNotifyApplication {

    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread threadOne = new Thread(() -> {
            try {
                taskOne();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadTwo = new Thread(() -> {
            try {
                taskTwo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadOne.start();
        threadTwo.start();
    }

    private static void taskOne() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Task One is waiting for lock ...");
            lock.wait();
            System.out.println("Lock is back to task one ...");
        }
    }

    private static void taskTwo() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Task Two is starting ...");
            lock.notify();
            System.out.println("Task Two is notifying ...");
        }
    }
}

```

Expected Result :

```
Task One is waiting for lock ...
Task Two is starting ...
Task Two is notifying ...
Lock is back to task one ... 
```


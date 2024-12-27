# Atomic Variable

### Read-Modify-Write Cycle

When we try to update a value of a variable, above three steps are involved.
So we cannot get expected results in concurrent context.

To solve that scenario ```Atomic variable``` is coming to picture. With this above-mentioned three steps are executed as atomic (non-divisible).
So synchronized blocks are no needed.

#### Types of atomic variables.
* ```AtomicInteger```
* ```AtomicLong```
* ```AtomicBoolean```

There are atomic variable for other types as well.

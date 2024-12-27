# Reentrant Lock

This lock is allowed to acquire same lock in multiple times for a thread without facing any **deadlock**.
When thread is acquiring the lock, in behind the scene, the hold count is increase. When releasing the lock (unlock()) hold count is decreased.

### Lock fairness
By default, reentrant locks are unfair.

When selecting the task from wait queue, the mechanism is fair in the fair locks.
But unfair locks are performed better due to lack of operations.

#### Methods of reentrant lock
* ```getHoldCount()``` - as earlier mentioned, it gives the count of no of times acquiring the lock.
* ```tryLock()``` - it returns boolean value which indicating the success of acquiring the lock.
* ```tryLock(timeout, timeunit)``` - this wait until timeout is expired to acquire the lock.
* There is an issue with ```tryLock()``` method. In fair scenario of the lock, If one thread release the lock, waiting
* tasks are not getting the priority. the thread which call ```tryLock()``` is got the priority to acquire the lock.
* ```isHeldByCurrentThread()``` - returns a boolean
* ```getQueueLength()``` - give the length of wait queue.

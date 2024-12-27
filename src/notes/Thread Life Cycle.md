# Thread Life Cycle

There are four state of thread life cycle.

### 1. New State
Every thread is in this state until that thread be called ```thread.start()```.

### 2. Active State
After a thread is called ```thread.start()```, then thread move to this state. 
It has two sub states.

#### i. Running
#### ii. Runnable

Depending on the CPU availability thread can be in either ```Running``` or 
```Runnable``` state.

### 3. Blocked State
When a thread is waiting for another thread, that is in blocked state.

### 4. Terminated State
After done the task, all threads are terminated.
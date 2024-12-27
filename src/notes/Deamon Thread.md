# Daemon Threads
Threads can be of two types.
#### i. Daemon Thread
#### ii. User Thread

User threads are child threads of main thread that created by user. Daemon threads are indented to be helper threads
which run in the background with low priority. Eg : ```Garbage Collection```

* When the time user threads are concluded, JVM conclude the main thread. By the time all daemon threads are terminated even though they haven't completed.
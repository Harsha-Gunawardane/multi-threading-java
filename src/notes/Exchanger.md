# Exchanger

* This is used to exchange data among threads.
* This is a generic class. So we need to pass what is the type of data that is to be exchanged.
* When a thread is called to ```.exchange()```, that thread is blocked until another thread is receiving to ```.exchange()``` method.

We use queues to data exchange. But there are several differences between queue and exchanger.

* Exchanger
  * Point To Point communication
  * Simplicity for two threads
  * Synchronous
  * Symmetrical exchange
  * bidirectional

* Queue
  * One to many communication
  * Asynchronous
  * Buffering
  * Non-symmetrical exchange
  * Queue is follow producer-consumer approach

Exchanger is similar to synchronous queue.
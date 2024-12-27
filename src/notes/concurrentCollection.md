# Concurrent Collection

Most of the collections in java is not thread safe.
There are two ways to make collections thread safe.
* Using ```Collections.synchronize()``` method
* Using concurrent collections

### Disadvantages of using ```Collections.synchronize```
* Coarse grained locking
    
    In this scenario one lock is used for the Collection. hence other unrelated tasks also is being waited for this operations.
* Limited Functionality
* Performance overhead
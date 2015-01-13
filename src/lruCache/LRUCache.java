package lruCache;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
    private java.util.LinkedHashMap<Integer, Integer> lruMap;

    public LRUCache(int capacity) {
        final int cap = capacity;
        lruMap = new java.util.LinkedHashMap<Integer, Integer>(cap + 1, .75F, true) {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
                return size() > cap;
            }
        };
    }

    public int get(int key) {
        if (lruMap.containsKey(key)) {
            return lruMap.get(key);
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        lruMap.put(key, value);
    }
}
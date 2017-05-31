package question.question100_199;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the 
 * following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before 
 * inserting a new item.
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//用一个Queue和一个HashMap来做果然还是不行的，因为每次调用Queue的remove方法都会遍历一下数组
//注：LinedList的优势在于poll和pop以及插入，而提供的remove方法并不建议多次调用
public class Question146_own {

	int capacity, count;
	HashMap<Integer, Integer> map;
	Queue<Integer> queue;

	public Question146_own(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Integer>();
		queue = new LinkedList<Integer>();
		count = 0;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		queue.remove(key);
		queue.add(key);
		return map.get(key);
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			map.put(key, value);
			queue.remove(key);
			queue.add(key);
		} else {
			if (count < capacity) {
				count++;
				map.put(key, value);
				queue.add(key);
			} else {
				int remove = queue.poll();
				queue.add(key);
				map.remove(remove);
				map.put(key, value);
			}
		}
	}
}

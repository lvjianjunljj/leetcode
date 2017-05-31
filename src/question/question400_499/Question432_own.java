package question.question400_499;
/*
 * Implement a data structure supporting the following operations:
 * Inc(Key) - Inserts a new key with value 1. 
 * Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. 
 * Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. 
 * Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */
import java.util.HashMap;

//不按要求都在O1时间内完成倒是也能AC，但是就没意思了
public class Question432_own {
	HashMap<String, Integer> map;

	/** Initialize your data structure here. */
	public Question432_own() {
		map = new HashMap<String, Integer>();
	}

	/**
	 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
	 */
	public void inc(String key) {
		if (!map.containsKey(key)) {
			map.put(key, 1);
		} else {
			int num = map.get(key) + 1;
			map.put(key, num);
		}

	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the
	 * data structure.
	 */
	public void dec(String key) {
		if (map.containsKey(key)) {
			if (map.get(key) == 1) {
				map.remove(key);
			} else {
				map.put(key, map.get(key) - 1);
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		int num = 0;
		for (String str : map.keySet()) {
			if (num < map.get(str)) {
				num = map.get(str);
			}
		}
		String res = "";
		for (String str : map.keySet()) {
			if (num == map.get(str)) {
				res = str;
				break;
			}
		}
		System.out.println(num);
		return res;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		int num = Integer.MAX_VALUE;
		for (String str : map.keySet()) {
			if (num > map.get(str)) {
				num = map.get(str);
			}
		}
		String res = "";
		for (String str : map.keySet()) {
			if (num == map.get(str)) {
				res = str;
				break;
			}
		}
		System.out.println(num);
		return res;
	}
}

/**
 * Your AllOne object will be instantiated and called as such: AllOne obj = new
 * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

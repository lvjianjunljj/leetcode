package question.question300_399;

/*
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. 
 * Each element must have the same probability of being returned.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//可以用HashMap存储一个val-index的关系和一个list存储val，确保在删除操作时直接通过map得到对应的index
//将其与最后一个元素对调然后删除最后一个元素
//其实功能上可以只用list实现（删除操作时时间为On——检索）或者只用HashSet实现（得到随机数时时间为On）但都不符合要求

public class Question380_others {

	HashMap<Integer, Integer> map;
	List<Integer> list;
	Random ra;

	/** Initialize your data structure here. */
	public Question380_others() {
		map = new HashMap<Integer, Integer>();
		list = new ArrayList<Integer>();
		ra = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;
		map.put(val, list.size());
		list.add(val);
		return true;

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;
		int index = map.get(val);
		if (index < list.size() - 1)
			list.set(index, list.get(list.size() - 1));
		map.put(list.get(list.size() - 1), index);
		map.remove(val);
		list.remove(list.size() - 1);
		return true;

	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(ra.nextInt(list.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */

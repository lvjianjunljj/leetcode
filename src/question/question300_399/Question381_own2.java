package question.question300_399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

//其实将index存成HashSet是可以做的，答案给的思路大部分都是这个样，大同小异了
public class Question381_own2 {

	HashMap<Integer, HashSet<Integer>> map;
	List<Integer> list;
	Random ra;

	/** Initialize your data structure here. */
	public Question381_own2() {
		map = new HashMap<Integer, HashSet<Integer>>();
		list = new ArrayList<Integer>();
		ra = new Random();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean res = !map.containsKey(val) || map.get(val).isEmpty();
		if (res)
			map.put(val, new HashSet<Integer>());
		map.get(val).add(list.size());
		list.add(val);
		return res;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val) || map.get(val).isEmpty())
			return false;
		HashSet<Integer> set = map.get(val);
		int index = set.iterator().next();
		set.remove(index);
		if (index < list.size() - 1) {
			list.set(index, list.get(list.size() - 1));
			map.get(list.get(list.size() - 1)).remove(list.size() - 1);
			map.get(list.get(list.size() - 1)).add(index);
		}
		list.remove(list.size() - 1);
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return list.get(ra.nextInt(list.size()));
	}
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
 * obj.getRandom();
 */

package question.question300_399;

/*
 * Design a data structure that supports all following operations in average O(1) time.
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element 
 * being returned is linearly related to the number of same value the collection contains.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//用380_others的思路确实能做，用List来存储每个数对应的多个index，耗时也确实降低了
//但是在remove的过程中为了使得要对调当前val和last的index所以需要遍历last对应的index数组以使得对应index数组是排好序的
//所以并不符合题目要求O1时间复杂度
public class Question381_own1 {

	HashMap<Integer, List<Integer>> map;
	List<Integer> list;
	Random ra;

	/** Initialize your data structure here. */
	public Question381_own1() {
		map = new HashMap<Integer, List<Integer>>();
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
			map.put(val, new ArrayList<Integer>());
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
		List<Integer> l = map.get(val);
		int index = l.remove(l.size() - 1);
		if (index < list.size() - 1) {
			list.set(index, list.get(list.size() - 1));
			List<Integer> tmp = map.get(list.get(list.size() - 1));
			tmp.remove(tmp.size() - 1);
			for (int i = 0; i <= tmp.size(); i++)
				if (i == tmp.size() || tmp.get(i) >= index) {
					tmp.add(i, index);
					break;
				}
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

package question.question100_199;
/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
import java.util.HashMap;
import java.util.Set;
//用HashMap数据结构的方法做
public class Question136_HashMap {
	public int singleNumber(int[] nums) {
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, 0);
			} else {
				map.put(i, 1);
			}
		}
		Set<Integer> set = map.keySet();
		for (int key : set) {
			if (map.get(key) == 1) {
				result = key;
			}
		}
		return result;
	}
}

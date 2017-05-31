package question.question100_199;

/*
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
import java.util.HashMap;

//这道题用HashMap一做就出来了，但是用O1时间复杂度确实不会做（位运算确实不知道），260是136和137的拓展，也很有意思
public class Question137_own {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				if (map.get(i))
					map.remove(i);
				else
					map.put(i, true);
			} else
				map.put(i, false);
		}
		for (int i : map.keySet())
			return i;
		return 0;
	}
}

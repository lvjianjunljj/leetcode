package question.question400_499;

import java.util.*;

/**
 * @author lvjj
 * @date 2017年4月22日
 * 
 */
public class Question494_own1 {
	public static void main(String[] args) {
		findTargetSumWays(new int[] { 1, 1, 1 }, 3);
	}

	public static int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		for (int i : nums) {
			Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
			for (int j : map.keySet()) {
				if (tmp.containsKey(i + j)) {
					tmp.put(i + j, map.get(i + j) + 1);
				} else {
					tmp.put(i + j, 1);
				}
				if (tmp.containsKey(j - i)) {
					tmp.put(j - i, tmp.get(j - i) + 1);
				} else {
					tmp.put(j - i, 1);
				}
			}
			map = tmp;
		}
		for (int j : map.keySet()) {
			System.out.println(j + " " + map.get(j));
		}
		return map.containsKey(S) ? map.get(S) : 0;
	}
}

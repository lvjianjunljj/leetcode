package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//这道题也可以用位运算做，也不麻烦
public class Question90_others2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		int n = nums.length;
		int count = 1 << n;
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < count; i++) {
			List<Integer> element = new ArrayList<Integer>();
			boolean repeat = false;
			for (int j = 0; j < n; j++) {
				if (((i >> j) & 1) > 0) {
					if (j > 0 && nums[j] == nums[j - 1]
							&& ((i >> (j - 1)) & 1) == 0) {
						repeat = true;
						break;
					}
					element.add(nums[j]);
				}
			}
			if (!repeat)
				res.add(element);
		}
		return res;
	}
}

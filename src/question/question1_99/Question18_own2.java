package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//精简了一下
public class Question18_own2 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int start = j + 1, end = nums.length - 1;
				int tar = target - nums[i] - nums[j];
				while (start < end) {
					int cur = nums[start] + nums[end];
					if (start > j + 1 && nums[start] == nums[start - 1]) {
						start++;
					} else if (end < nums.length - 1
							&& nums[end] == nums[end + 1]) {
						end--;
					} else if (cur == tar) {
						res.add(Arrays.asList(nums[i], nums[j], nums[start],
								nums[end]));
						start++;
						end--;
					} else if (cur < tar) {
						start++;
					} else {
						end--;
					}
				}
			}
		}
		return res;
	}
}

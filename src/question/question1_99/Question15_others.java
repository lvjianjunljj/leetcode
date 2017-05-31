package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//和我的想法差不了太对，实现的还是很好的
public class Question15_others {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int start = i + 1;
			int end = nums.length - 1;
			int target = 0 - nums[i];
			while (start < end) {
				int sum = nums[start] + nums[end];
				if (sum > target)
					end--;
				else if (sum < target)
					start++;
				else {
					List<Integer> element = new ArrayList<Integer>();
					element.add(nums[i]);
					element.add(nums[start]);
					element.add(nums[end]);
					res.add(element);
					while (start < end && nums[start] == nums[start + 1])
						start++;
					while (start < end && nums[end] == nums[end - 1])
						end--;
					start++;
					end--;
				}
			}
		}
		return res;
	}
}

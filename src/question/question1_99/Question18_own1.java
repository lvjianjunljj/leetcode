package question.question1_99;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//仿照3Sum写的，耗时还算是比较低
public class Question18_own1 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j - 1] == nums[j])
					continue;
				int start = j + 1;
				int end = nums.length - 1;
				int tar = target - nums[i] - nums[j];
				while (start < end) {
					int sum = nums[start] + nums[end];
					if (sum < tar)
						start++;
					else if (sum > tar)
						end--;
					else {
						List<Integer> element = new ArrayList<Integer>();
						element.add(nums[i]);
						element.add(nums[j]);
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
		}
		return res;
	}
}

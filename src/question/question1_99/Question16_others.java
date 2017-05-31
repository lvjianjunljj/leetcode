package question.question1_99;

import java.util.Arrays;
//排完序以后这个想法还是非常巧妙地，是可以降后两个数向中间靠拢的，不用担心漏掉某些情况
public class Question16_others {
	public int threeSumClosest(int[] nums, int target) {
		int dif = Integer.MAX_VALUE;
		int res = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum > target)
					end--;
				else if (sum < target)
					start++;
				else
					return target;
				if (dif > Math.abs(sum - target)) {
					res = sum;
					dif = Math.abs(sum - target);
				}
			}
		}
		return res;
	}
}

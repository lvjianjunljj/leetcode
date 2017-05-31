package question.question300_399;

import java.util.Arrays;

//居然没有想到，我对动态规划的理解越来越局限了——菜！！！！！！！！（这道题根本就不难）
public class Question377_others1 {
	public int combinationSum4(int[] nums, int target) {
		int[] res = new int[target];
		Arrays.sort(nums);
		for (int i = 0; i < res.length; i++)
			for (int num : nums) {
				if (num > i + 1)
					break;
				else if (num == i + 1)
					res[i]++;
				else
					res[i] += res[i - num];
			}
		return res[target - 1];
	}
}

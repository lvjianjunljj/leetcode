package question.question300_399;

import java.util.Arrays;

//对others1的代码进行精简，其实想法都一样
public class Question377_others2 {
	public int combinationSum4(int[] nums, int target) {
		int[] res = new int[target + 1];
		res[0] = 1;
		Arrays.sort(nums);
		for (int i = 1; i < res.length; i++)
			for (int num : nums) {
				if (num > i)
					break;
				else
					res[i] += res[i - num];
			}
		return res[target];
	}
}

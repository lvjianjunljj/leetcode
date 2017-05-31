package question.question300_399;

//用我比较熟悉的动态规划的思路做简直是耗时极高啊
public class Question334_own2 {
	public boolean increasingTriplet(int[] nums) {
		int n = nums.length;
		if (n < 3)
			return false;
		int[] sums = new int[n];
		for (int i = 1; i < n; i++) {
			sums[i] = 0;
			for (int j = 0; j < i; j++)
				if (nums[i] > nums[j])
					sums[i] = Math.max(sums[i], sums[j] + 1);
			if (sums[i] > 1)
				return true;
		}
		return false;
	}
}

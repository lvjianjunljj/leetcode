package question.question300_399;

import java.util.Arrays;

//仿照Question300_others的方法写的，好事果然很低——厉害
public class Question334_others1 {
	public boolean increasingTriplet(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int i : nums) {
			int j = Arrays.binarySearch(dp, 0, len, i);
			if (j < 0)
				j = -(j + 1);
			dp[j] = i;
			if (j == len)
				len++;
			if (len > 2)
				return true;
		}
		return false;
	}
}

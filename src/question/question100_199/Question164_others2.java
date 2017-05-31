package question.question100_199;

//基数排序来做，我已经不太有印象了——时间复杂度也算是On
public class Question164_others2 {
	public int maximumGap(int[] nums) {
		int n = nums.length;
		if (n < 2)
			return 0;
		int m = Integer.MIN_VALUE, exp = 1, sum = 10, res = 0;
		for (int i : nums)
			m = Math.max(m, i);
		int[] tmp = new int[n];
		while (m / exp > 0) {
			int[] count = new int[10];
			for (int i : nums)
				count[i / exp % 10]++;
			for (int i = 1; i < 10; i++)
				count[i] += count[i - 1];
			for (int i = n - 1; i >= 0; i--)
				tmp[--count[nums[i] / exp % 10]] = nums[i];
			for (int i = 0; i < n; i++)
				nums[i] = tmp[i];
			exp *= 10;
		}
		for (int i = 1; i < n; i++)
			res = Math.max(res, nums[i] - nums[i - 1]);
		return res;
	}
}

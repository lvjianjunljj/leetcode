package question.question100_199;
//网上给的空间复杂度为O1的方法。思路是反转整个数组，然后再反转前k个，再反转后面n-k个。
public class Question189_others {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k= k%n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	protected static void reverse(int[] nums, int i, int j) {
		for (int k = i; k < (i + j + 1) / 2; k++) {
			int tran = nums[k];
			nums[k] = nums[j + i - k];
			nums[j + i - k] = tran;
		}
	}
}

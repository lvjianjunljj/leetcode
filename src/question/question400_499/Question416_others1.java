package question.question400_499;

//果然还是用动态规划比较快——有时候动态规划也是要两层循环的，别太固化动态规划的想法（不一定都是一层循环）
public class Question416_others1 {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (sum % 2 == 1) {
			return false;
		}
		sum = sum / 2;
		boolean[] res = new boolean[sum + 1];
		res[0] = true;
		for (int i : nums) {
			for (int j = sum; j >= i; j--) {
				res[j] = res[j - i] || res[j];
			}
		}
		return res[sum];
	}
}

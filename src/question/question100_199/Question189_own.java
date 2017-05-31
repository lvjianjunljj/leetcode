package question.question100_199;

/*
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
//不知道能不能做到孔家复杂度为O1。
public class Question189_own {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int[] tran = new int[k];
		for (int i = 0; i < k; i++) {
			tran[i] = nums[n - k + i];
		}
		for (int i = 0; i < n - k; i++) {
			nums[n - 1 - i] = nums[n - 1 - i - k];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = tran[i];
		}
	}
}

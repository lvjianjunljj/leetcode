package question.question300_399;
//其实答案的思路还是非常清晰的，根据答案自己写的，maxArray方法不太一样，是自己写的，所以耗时长了一些
public class Question322_own2 {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int m = nums1.length;
		int n = nums2.length;
		int[] res = new int[k];
		for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
			int[] element = merge(maxArray(nums1, i), maxArray(nums2, k - i));
			if (greater(element, 0, res, 0))
				res = element;
		}
		return res;
	}

	protected int[] merge(int[] nums1, int[] nums2) {
		int k = nums1.length + nums2.length;
		int[] ans = new int[k];
		for (int i = 0, j = 0, r = 0; r < k; ++r)
			ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
		return ans;
	}

	protected boolean greater(int[] nums1, int i, int[] nums2, int j) {
		while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
			i++;
			j++;
		}
		return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
	}

	protected int[] maxArray(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[k];
		int j = 0;
		for (int i = 0; i < k; i++) {
			for (int s = j; s <= n + i - k; s++) {
				if (res[i] < nums[s]) {
					res[i] = nums[s];
					j = s + 1;
				}
			}
		}
		return res;
	}
}

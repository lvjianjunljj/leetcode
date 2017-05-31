package question.question300_399;

public class Question324_others3 {
	public void wiggleSort(int[] nums) {
		int median = findKthLargest(nums, (nums.length + 1) / 2);
		int n = nums.length;

		int left = 0, i = 0, right = n - 1;

		while (i <= right) {

			if (nums[newIndex(i, n)] > median) {
				swap(nums, newIndex(left++, n), newIndex(i++, n));
			} else if (nums[newIndex(i, n)] < median) {
				swap(nums, newIndex(right--, n), newIndex(i, n));
			} else {
				i++;
			}
		}

	}

	private int newIndex(int index, int n) {
		return (1 + 2 * index) % (n | 1);
	}

	private int findKthLargest(int[] nums, int k) {
		if (k < 1 || k > nums.length) {
			throw new IllegalArgumentException("length=" + nums.length + " k="
					+ k);
		}
		int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left < 0 && right > 0) ? (left + right) / 2 : left
					+ (right - left) / 2;
			int cl = 0, cg = 0, d = 0;
			for (int n : nums) {
				if (n < mid) {
					if (++cl > k - 1) {
						d = +1; // mid larger than kth
						break;
					}
				} else if (n > mid) {
					if (++cg > (nums.length - k)) {
						d = -1; // mid smaller than kth
						break;
					}
				}
			}
			if (d == 0) {
				return mid;
			} else if (d < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		throw new AssertionError();
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

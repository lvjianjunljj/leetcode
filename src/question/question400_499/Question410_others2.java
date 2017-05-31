package question.question400_499;

//这道题没想到可以用这么简单的BinarySearch来做，简直精辟
public class Question410_others2 {
	public int splitArray(int[] nums, int m) {
		long low = 0, high = 0;
		for (int i : nums) {
			high += i;
			if (i > low)
				low = i;
		}
		return (int) search(nums, m, low, high);
	}

	private long search(int[] nums, int m, long low, long high) {
		while (low < high) {
			long mid = (low + high) / 2;
			if (judge(nums, m, mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}

	private boolean judge(int[] nums, int m, long max) {
		long cur = 0;
		int count = 1;
		for (int num : nums) {
			cur += num;
			if (cur > max) {
				cur = num;
				if (count++ == m)
					return false;
			}
		}
		return true;
	}
}

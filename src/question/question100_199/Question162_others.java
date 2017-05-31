package question.question100_199;

//因为num[-1] = num[n] = -∞.所以可以将左右两边看作是对称的升势，然后将这个升势向中间移动就行，这个想法确实是精妙
//这个二分查找只要看中间值的状态就能找到对应下一层的半个区间
public class Question162_others {
	public int findPeakElement(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}

	private int search(int[] nums, int i, int j) {
		if (i == j)
			return i;
		int mid = (i + j) / 2;
		if (nums[mid] > nums[mid + 1])
			return search(nums, i, mid);
		else
			return search(nums, mid + 1, j);
	}
}

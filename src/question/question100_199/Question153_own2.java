package question.question100_199;

//用迭代实现binary search，也是非常容易的
public class Question153_own2 {
	public int findMin(int[] nums) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int mid = (i + j) / 2;
			if (nums[mid] > nums[j])
				i = mid + 1;
			else
				j = mid;
		}
		return nums[j];
	}
}

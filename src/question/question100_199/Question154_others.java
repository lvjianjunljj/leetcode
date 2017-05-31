package question.question100_199;

//答案给的都是这种解法，和我的方法比起来并不比我好太多
public class Question154_others {
	public int findMin(int[] nums) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int mid = (i + j) / 2;
			if (nums[mid] > nums[j])
				i = mid + 1;
			else if (nums[mid] < nums[j])
				j = mid;
			else
				j--;
		}
		return nums[i];
	}
}

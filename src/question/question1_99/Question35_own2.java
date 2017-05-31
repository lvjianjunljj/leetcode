package question.question1_99;

//刚才写的二分查找简直就是一坨屎，这才是正规的二分查找
public class Question35_own2 {
	public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, index = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}

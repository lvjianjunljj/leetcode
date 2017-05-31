package question.question100_199;

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
//和229题是一个类别的，而且题目说了一定存在majorityElement所以直接进行循环就行，最后也不需要判断
public class Question169_own {
	public int majorityElement(int[] nums) {
		int count = 1;
		int num = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == num)
				count++;
			else if (count == 0) {
				num = nums[i];
				count = 1;
			} else {
				count--;
			}
		}
		return num;
	}
}

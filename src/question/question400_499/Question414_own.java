package question.question400_499;
/*
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */

//把情况分清楚，写的麻烦，但是思路清晰
public class Question414_own {
	public int thirdMax(int[] nums) {
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = Integer.MAX_VALUE, full = 3;
		for (int i : nums) {
			if (full == 3) {
				third = i;
				full--;
			} else if (full == 2) {
				if (i != third) {
					int tmp = third;
					third = Math.min(tmp, i);
					second = Math.max(tmp, i);
					full--;
				}
			} else if (full == 1) {
				if (i < third) {
					first = second;
					second = third;
					third = i;
					full--;
				} else if (i > third && i < second) {
					first = second;
					second = i;
					full--;
				} else if (i > second) {
					first = i;
					full--;
				}
			} else {
				if (i > third && i < second) {
					third = i;
				} else if (i > second && i < first) {
					third = second;
					second = i;
				} else if (i > first) {
					third = second;
					second = first;
					first = i;
				}
			}
		}
		return first == Integer.MAX_VALUE ? (second == Integer.MAX_VALUE ? third
				: second)
				: third;
	}
}

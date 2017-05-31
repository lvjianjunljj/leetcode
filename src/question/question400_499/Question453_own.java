package question.question400_499;

/*
 * Given a non-empty integer array of size n, find the minimum number of moves required to 
 * make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 3
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

//没意思，太简单了
public class Question453_own {
	public int minMoves(int[] nums) {
		int res = 0, min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (min > nums[i]) {
				min = nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			res += nums[i] - min;
		}
		return res;
	}
}

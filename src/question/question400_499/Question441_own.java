package question.question400_499;
/*
 * You have a total of n coins that you want to form in a staircase shape, 
 * where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Example 1:
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 */

//用二分查找直接就能做出来了，没意思
public class Question441_own {
	public int arrangeCoins(int n) {
        long min = 0, max = 1 << 16;
		while (min < max) {
			long mid = (min + max + 1) / 2;
			if (mid * (mid + 1) / 2 > n) {
				max = mid - 1;
			} else {
				min = mid;
			}
		}
		return (int) min;
	}
}

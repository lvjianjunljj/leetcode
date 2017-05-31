package question.question1_99;
/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
//之前遇到过类似的题，只要有了合适的思路很快就能出来，先找到制高点，然后分别从左到右和从右到左个遍历一遍就出来了。
public class Question42_own1 {
	public int trap(int[] height) {
		int max = Integer.MIN_VALUE;
		int mark = 0;
		int result = 0;
		int n = height.length;
		for (int i = 0; i < n; i++) {
			if (height[i] > max) {
				max = height[i];
				mark = i;
			}
		}
		for (int i = 0; i < mark; i++) {
			if (height[i + 1] < height[i]) {
				result += height[i] - height[i + 1];
				height[i + 1] = height[i];
			}
		}
		for (int i = n - 1; i > mark; i--) {
			if (height[i - 1] < height[i]) {
				result += height[i] - height[i - 1];
				height[i - 1] = height[i];
			}
		}
		return result;
	}
}

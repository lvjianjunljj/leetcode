package question.question300_399;

/*
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, 
 * then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, 
 * after each move your direction changes counter-clockwise.
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 * Example 1:
 * Given x = [2, 1, 1, 2],
 ┌───┐
 │   │
 └───┼──>
     │
 Return true (self crossing)
 */

//不要被这道题吓坏了，其实能相交的就三种情况，所以最多从x[i]到x[i - 5]之间进行一些判断就好了
public class Question335_others {
	public boolean isSelfCrossing(int[] x) {
		int n = x.length;
		for (int i = 3; i < n; i++) {
			if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3])
				return true;
			if (i > 3 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
				return true;
			if (i > 4 && x[i - 4] <= x[i - 2] && x[i] + x[i - 4] >= x[i - 2]
					&& x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3])
				return true;
		}
		return false;
	}
}

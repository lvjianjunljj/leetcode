package question.question200_299;
/*
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

import java.util.ArrayList;
//根据题意很快就能出来了
public class Question202_own {
	public boolean isHappy(int n) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while (n != 1 && nums.indexOf(n) < 0) {
			nums.add(n);
			n = aux(n);
		}
		return n == 1;

	}

	public static int aux(int n) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while (n > 0) {
			nums.add(n % 10);
			n = n / 10;
		}
		int res = 0;
		for (int i : nums)
			res += i * i;
		return res;
	}
}

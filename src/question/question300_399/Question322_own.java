package question.question300_399;
/*
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 */
import java.util.Arrays;
import java.util.HashSet;
//比较麻烦的动态规划，将1到amount的所有值的结果都求出来（考虑的太多，没必要用-1表示无法凑齐而可以直接用Integer.MAX_VALUE表示）
//加了一个hashset奕玮节省了时间，但其实并没有，其实将res的长度变成amount + 1这些东西就都能省了
public class Question322_own {
	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		if (amount < 1)
			return 0;
		int[] res = new int[amount];
		boolean have = false;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : coins)
			set.add(i);
		for (int i = 0; i < amount; i++) {
			have = false;
			res[i] = Integer.MAX_VALUE;
			if (set.contains(i + 1)) {
				res[i] = 1;
				continue;
			}
			for (int j = 0; j < coins.length; j++) {
				if (j > 0 && coins[j] == coins[j - 1])
					continue;
				if (coins[j] > i + 1)
					break;
				if (res[i - coins[j]] > -1) {
					res[i] = Math.min(res[i - coins[j]] + 1, res[i]);
					have = true;
				}
			}
			if (!have)
				res[i] = -1;
		}
		return res[amount - 1];
	}
	
	public int coinChange2(int[] coins, int amount) {
		Arrays.sort(coins);
		if (amount < 1)
			return 0;
		int[] res = new int[amount];
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : coins)
			set.add(i);
		for (int i = 0; i < amount; i++) {
			res[i] = Integer.MAX_VALUE;
			if (set.contains(i + 1)) {
				res[i] = 1;
				continue;
			}
			for (int j = 0; j < coins.length; j++) {
				if (j > 0 && coins[j] == coins[j - 1])
					continue;
				if (coins[j] > i + 1)
					break;
				if (res[i - coins[j]] < Integer.MAX_VALUE) 
					res[i] = Math.min(res[i - coins[j]] + 1, res[i]);
			}
		}
		
		return res[amount - 1] == Integer.MAX_VALUE ? -1 : res[amount - 1];
	}
}

package question.question100_199;

/*
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

//之前做过类似的题，从左向右遍历一遍然后再从右向左遍历一遍就结束了——需要一个candys数组保存每个人的糖果数
//想不到O1空间复杂度的办法
public class Question135_own {
	public int candy(int[] ratings) {
		int n = ratings.length;
		int[] candys = new int[n];
		for (int i = 1; i < n; i++)
			if (ratings[i] > ratings[i - 1])
				candys[i] = candys[i - 1] + 1;
		for (int i = n - 1; i > 0; i--)
			if (ratings[i] < ratings[i - 1] && candys[i] >= candys[i - 1])
				candys[i - 1] = candys[i] + 1;
		int res = n;
		for (int i : candys)
			res += i;
		return res;
	}
}

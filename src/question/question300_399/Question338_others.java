package question.question300_399;
/*
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate 
 * the number of 1's in their binary representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 */
//卧槽，动态规划加位运算，分分钟就出来了（后面的值依托于前面的值，确实是动态规划方法）
public class Question338_others {
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 1; i < num + 1; i++) {
			result[i] = result[i >> 1] + (i & 1);
		}
		return result;
	}
}

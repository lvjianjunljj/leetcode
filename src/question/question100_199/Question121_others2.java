package question.question100_199;

//根据123题的思路写出来的方法，这样就能做可以买入卖出k次的题了
//（这里是至多买入卖出一次，123是至多买入两次，188是至多买入k次）
public class Question121_others2 {
	public int maxProfit(int[] prices) {
		int b = Integer.MIN_VALUE, s = 0;
		for (int i : prices) {
			s = Math.max(s, b + i);
			b = Math.max(b, -i);
		}
		return s;
	}
}

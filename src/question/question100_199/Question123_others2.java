package question.question100_199;

//多次调用Math.max方法要比判断耗时高——这中写法的耗时会低一点
public class Question123_others2 {
	public int maxProfit(int[] prices) {
		int s0 = 0, s1 = 0, b0 = Integer.MIN_VALUE, b1 = Integer.MIN_VALUE;
		for (int i : prices) {
			if (s1 < b1 + i)
				s1 = b1 + i;
			if (b1 < s0 - i)
				b1 = s0 - i;
			if (s0 < b0 + i)
				s0 = b0 + i;
			if (b0 < -i)
				b0 = -i;
		}
		return s1;
	}
}

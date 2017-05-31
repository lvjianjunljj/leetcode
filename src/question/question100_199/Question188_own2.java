package question.question100_199;

import java.util.Arrays;

//和123题类似的比较——亲测耗时比own1低一些
public class Question188_own2 {
	public int maxProfit(int k, int[] prices) {
		if (k == 0)
			return 0;
		if (k >= prices.length / 2) {
			int sum = 0;
			for (int i = 1; i < prices.length; i++)
				if (prices[i] > prices[i - 1])
					sum += prices[i] - prices[i - 1];
			return sum;
		}
		int[] b = new int[k];
		int[] s = new int[k];
		Arrays.fill(b, Integer.MIN_VALUE);
		for (int i : prices) {
			for (int j = k - 1; j > 0; j--) {
				if (s[j] < b[j] + i)
					s[j] = b[j] + i;
				if (b[j] < s[j - 1] - i)
					b[j] = s[j - 1] - i;
			}
			if (s[0] < b[0] + i)
				s[0] = b[0] + i;
			if (b[0] < -i)
				b[0] = -i;
		}
		return s[k - 1];
	}
}

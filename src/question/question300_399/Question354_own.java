package question.question300_399;
/*
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
import java.util.Arrays;
import java.util.Comparator;
//用动态规划还是很好做的，并不是很难。
public class Question354_own {
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		if (n == 0)
			return 0;
		int[] res = new int[n];
		for (int i = 0; i < n; i++)
			res[i] = 1;
		Comparator c = new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((int[]) o1)[0])
						.compareTo(((int[]) o2)[0]);
			}
		};
		Arrays.sort(envelopes, c);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++)
				if (envelopes[i][0] > envelopes[j][0]
						&& envelopes[i][1] > envelopes[j][1])
					res[i] = Math.max(res[i], res[j] + 1);
		}
		int max = 1;
		for (int i : res)
			max = Math.max(max, i);
		return max;
	}
}

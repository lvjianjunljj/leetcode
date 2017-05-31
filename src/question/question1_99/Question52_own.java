package question.question1_99;

/*
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */

//和51题完全一样，只是不用再去维护对应位置的String数组了
public class Question52_own {

	int count = 0;

	public int totalNQueens(int n) {
		int[] index = new int[n];
		add(index, 0, n);
		return count;
	}

	private void add(int[] index, int high, int n) {
		if (high == n && judge(index, high))
			count++;
		if (high >= n)
			return;
		for (int i = 0; i < n; i++) {
			index[high] = i;
			if (high == 0 || judge(index, high))
				add(index, high + 1, n);
		}
	}

	private boolean judge(int[] index, int high) {
		int in = index[high - 1];
		for (int i = high - 2; i >= 0; i--)
			if (in == index[i] || high - 1 - i == Math.abs(in - index[i]))
				return false;
		return true;
	}
}

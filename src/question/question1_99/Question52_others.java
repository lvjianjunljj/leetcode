package question.question1_99;

//用51_others的思路做耗时果然非常低了——美妙
public class Question52_others {

	int count = 0;

	public int totalNQueens(int n) {
		add(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1],
				n);
		return count;
	}

	private void add(int r, boolean[] in, boolean[] in1, boolean[] in2, int n) {
		if (r == n)
			count++;
		else
			for (int i = 0; i < n; i++)
				if (!in[i] && !in1[r - i + n - 1] && !in2[r + i]) {
					in[i] = true;
					in1[r - i + n - 1] = true;
					in2[r + i] = true;
					add(r + 1, in, in1, in2, n);
					in[i] = false;
					in1[r - i + n - 1] = false;
					in2[r + i] = false;
				}
	}
}

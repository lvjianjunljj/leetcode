package question.question100_199;

//这才是最合理的动态规划的方法，对于某一段是不是回文也要用动态规划去维护，而不是单独判断
public class Question132_others {
	public int minCut(String s) {
		char[] list = s.toCharArray();
		int n = list.length;
		boolean[][] mark = new boolean[n][n];
		int[] cuts = new int[n];
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (list[j] == list[i] && (j + 2 > i || mark[j + 1][i - 1])) {
					mark[j][i] = true;
					min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
				}
			}
			cuts[i] = min;
		}
		return cuts[n - 1];
	}
}

package question.question100_199;
//既然从头到尾的思路不行，那就尝试一下从尾到头的动态规划的想法，果然巧妙
public class Question174_others {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		if (m == 0)
			return 1;
		int n = dungeon[0].length;
		int[][] res = new int[m][n];
		res[m - 1][n - 1] = dungeon[m - 1][n - 1] < 0 ? 1 - dungeon[m - 1][n - 1]
				: 1;
		for (int i = n - 2; i > -1; i--)
			res[m - 1][i] = Math.max(res[m - 1][i + 1] - dungeon[m - 1][i], 1);
		for (int i = m - 2; i > -1; i--)
			res[i][n - 1] = Math.max(res[i + 1][n - 1] - dungeon[i][n - 1], 1);
		for (int i = m - 2; i > -1; i--) {
			for (int j = n - 2; j > -1; j--) {
				int right = Math.max(res[i][j + 1] - dungeon[i][j], 1);
				int down = Math.max(res[i + 1][j] - dungeon[i][j], 1);
				res[i][j] = Math.min(right, down);
			}
		}
		return res[0][0];
	}
}

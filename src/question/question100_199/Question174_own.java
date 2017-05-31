package question.question100_199;

/*
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 -2 (K)	-3	3
 -5	-10	1
 10	30	-5 (P)
 */
//思路确实有问题，并不一定对
//对于输入[[1,-3,3],[0,-2,0],[-3,-3,-3]]的结果并不对
public class Question174_own {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		if (m == 0)
			return 0;
		int n = dungeon[0].length;
		int[][] res = new int[m][n];
		int[][] rem = new int[m][n];
		if (dungeon[0][0] < 1) {
			res[0][0] = 1 - dungeon[0][0];
			rem[0][0] = 1;
		} else {
			res[0][0] = 1;
			rem[0][0] = 1 + dungeon[0][0];
		}

		for (int i = 1; i < m; i++) {
			if (rem[i - 1][0] + dungeon[i][0] > 0) {
				rem[i][0] = rem[i - 1][0] + dungeon[i][0];
				res[i][0] = res[i - 1][0];
			} else {
				rem[i][0] = 1;
				res[i][0] = 1 + res[i - 1][0] - rem[i - 1][0] - dungeon[i][0];
			}
		}
		for (int i = 1; i < n; i++) {
			if (rem[0][i - 1] + dungeon[0][i] > 0) {
				rem[0][i] = rem[0][i - 1] + dungeon[0][i];
				res[0][i] = res[0][i - 1];
			} else {
				rem[0][i] = 1;
				res[0][i] = 1 + res[0][i - 1] - rem[0][i - 1] - dungeon[0][i];
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int rem1, rem2, res1, res2;
				if (rem[i - 1][j] + dungeon[i][j] > 0) {
					rem1 = rem[i - 1][j] + dungeon[i][j];
					res1 = res[i - 1][j];
				} else {
					rem1 = 1;
					res1 = 1 + res[i - 1][j] - rem[i - 1][j] - dungeon[i][j];
				}

				if (rem[i][j - 1] + dungeon[i][j] > 0) {
					rem2 = rem[i][j - 1] + dungeon[i][j];
					res2 = res[i][j - 1];
				} else {
					rem2 = 1;
					res2 = 1 + res[i][j - 1] - rem[i][j - 1] - dungeon[i][j];
				}
				res[i][j] = Math.min(res1, res2);
				if (res1 < res2)
					rem[i][j] = rem1;
				else if (res1 > res2)
					rem[i][j] = rem2;
				else
					rem[i][j] = Math.max(rem1, rem2);
			}
		}
		return res[m - 1][n - 1];
	}
}

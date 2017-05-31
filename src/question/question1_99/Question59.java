package question.question1_99;
/*
 * 螺旋输入
 */
public class Question59 {
	public int[][] generateMatrix(int n) {
		String turn = "right";
		int[][] mark = new int[n + 2][n + 2];
		int[][] result = new int[n][n];
		if (n == 0) {
			return result;
		}
		int i = 1, j = 1;
		for (int k = 0; k < n + 2; k++) {
			mark[0][k] = 1;
			mark[n + 1][k] = 1;
		}
		for (int k = 0; k < n + 2; k++) {
			mark[k][0] = 1;
			mark[k][n + 1] = 1;
		}
		int k = 1;
		//避免n是1的输入，必须先对第一个点进行赋值
		result[0][0] = 1;
		mark[1][1] = 1;
		while (mark[i - 1][j] == 0 || mark[i + 1][j] == 0
				|| mark[i][j - 1] == 0 || mark[i][j + 1] == 0) {
			result[i - 1][j - 1] = k;
			mark[i][j] = 1;
			if (turn == "right") {
				if (mark[i][j + 1] == 0) {
					j++;
				} else {
					turn = "down";
					i++;
				}
			} else if (turn == "down") {
				if (mark[i + 1][j] == 0) {
					i++;
				} else {
					turn = "left";
					j--;
				}
			} else if (turn == "left") {
				if (mark[i][j - 1] == 0) {
					j--;
				} else {
					turn = "up";
					i--;
				}
			} else if (turn == "up") {
				if (mark[i - 1][j] == 0) {
					i--;
				} else {
					turn = "right";
					j++;
				}
			}
			k++;
		}
		// 果然还是需要最后一步的最后一个点的赋值
		result[i - 1][j - 1] = k;
		return result;
	}
}

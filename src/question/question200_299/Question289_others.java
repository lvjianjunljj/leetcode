package question.question200_299;
//既然要在元素组上进行操作，而且原数组只有0和1，完全可以将新的值放在二进制的第二位上，然后用位运算做——确实是个好想法
public class Question289_others {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		if (m == 0)
			return;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int neg = aux(board, i, j);
				if (neg == 2)
					board[i][j] *= 3;
				else if (neg == 3)
					board[i][j] += 2;
			}
		}
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = board[i][j] / 2;
	}

	protected static int aux(int[][] board, int i, int j) {
		int res = 0;
		if (i != 0)
			res += board[i - 1][j] & 1;
		if (j != 0)
			res += board[i][j - 1] & 1;
		if (i != board.length - 1)
			res += board[i + 1][j] & 1;
		if (j != board[0].length - 1)
			res += board[i][j + 1] & 1;
		if (i != 0 && j != 0)
			res += board[i - 1][j - 1] & 1;
		if (i != 0 && j != board[0].length - 1)
			res += board[i - 1][j + 1] & 1;
		if (i != board.length - 1 && j != 0)
			res += board[i + 1][j - 1] & 1;
		if (i != board.length - 1 && j != board[0].length - 1)
			res += board[i + 1][j + 1] & 1;
		return res;
	}
}

package question.question200_299;

/*
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 */
//我自己的想打就是用一个新的数组存储结果然后赋值给原数组
public class Question289_own {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		if (m == 0)
			return;
		int n = board[0].length;
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int neg = aux(board, i, j);
				if (neg == 2)
					res[i][j] = board[i][j];
				else if (neg == 3)
					res[i][j] = 1;
				else
					res[i][j] = 0;
			}
		}
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = res[i][j];
	}

	protected static int aux(int[][] board, int i, int j) {
		int res = 0;
		if (i != 0)
			res += board[i - 1][j];
		if (j != 0)
			res += board[i][j - 1];
		if (i != board.length - 1)
			res += board[i + 1][j];
		if (j != board[0].length - 1)
			res += board[i][j + 1];
		if (i != 0 && j != 0)
			res += board[i - 1][j - 1];
		if (i != 0 && j != board[0].length - 1)
			res += board[i - 1][j + 1];
		if (i != board.length - 1 && j != 0)
			res += board[i + 1][j - 1];
		if (i != board.length - 1 && j != board[0].length - 1)
			res += board[i + 1][j + 1];
		return res;
	}
}

package question.question400_499;

/*
 * Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, 
 * empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, 
 * they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is not a valid board - as battleships will always have a cell separating between them.
 */

//其实思路还是非常清晰的，分好纵向和横向就行了
public class Question419_own {
	public int countBattleships(char[][] board) {
		int m = board.length;
		if (m == 0) {
			return 0;
		}
		int n = board[0].length;
		char[][] grid = new char[m + 2][n + 2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grid[i + 1][j + 1] = board[i][j];
			}
		}
		for (int i = 0; i < m + 2; i++) {
			grid[i][0] = '.';
			grid[i][n + 1] = '.';
		}
		for (int i = 0; i < n + 2; i++) {
			grid[0][i] = '.';
			grid[m + 1][i] = '.';
		}
		int res = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (grid[i][j] == 'X') {
					if (grid[i][j + 1] == 'X') {
						if (horizontal(grid, i, j)) {
							res++;
						}
					} else {
						if (vertical(grid, i, j)) {
							res++;
						}
					}
				}
			}
		}
		return res;
	}

	private boolean horizontal(char[][] board, int i, int j) {
		board[i][j] = '.';
		if (board[i + 1][j] == 'X' || board[i - 1][j] == 'X') {
			diffusion(board, i, j);
			return false;
		}
		if (board[i][j + 1] == 'X' && !horizontal(board, i, j + 1)) {
			return false;
		}
		return true;
	}

	private boolean vertical(char[][] board, int i, int j) {
		board[i][j] = '.';
		if (board[i][j + 1] == 'X' || board[i][j - 1] == 'X') {
			diffusion(board, i, j);
			return false;
		}
		if (board[i + 1][j] == 'X' && !vertical(board, i + 1, j)) {
			return false;
		}
		return true;
	}

	private void diffusion(char[][] board, int i, int j) {
		board[i][j] = '.';
		if (board[i + 1][j] == 'X') {
			diffusion(board, i + 1, j);
		}
		if (board[i - 1][j] == 'X') {
			diffusion(board, i - 1, j);
		}
		if (board[i][j + 1] == 'X') {
			diffusion(board, i, j + 1);
		}
		if (board[i][j - 1] == 'X') {
			diffusion(board, i, j - 1);
		}
	}
}

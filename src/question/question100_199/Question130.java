package question.question100_199;

/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class Question130 {
	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i == 0 || i == board.length - 1 || j == 0
						|| j == board[0].length - 1) {
					if (board[i][j] == 'O')
						dfs(i, j, board);
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '*')
					board[i][j] = 'O';
				else
					board[i][j] = 'X';
			}
		}
		return;
	}

	private void dfs(int i, int j, char[][] board) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return;
		if (board[i][j] == 'X' || board[i][j] == '*')
			return;
		board[i][j] = '*';
		if (i + 1 < board.length)
			dfs(i + 1, j, board);
		if (i - 1 > 0)
			dfs(i - 1, j, board);
		if (j + 1 < board[0].length)
			dfs(i, j + 1, board);
		if (j - 1 > 0)
			dfs(i, j - 1, board);
	}
}

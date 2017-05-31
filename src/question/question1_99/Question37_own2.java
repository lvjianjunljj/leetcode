package question.question1_99;

//回首在做这道题其实并不难
public class Question37_own2 {
	public void solveSudoku(char[][] board) {
		dfs(board, 0, 0);
	}

	private boolean dfs(char[][] board, int i, int j) {
		if (i > 8) {
			return true;
		}
		if (board[i][j] == '.') {
			for (int k = 1; k < 10; k++) {
				board[i][j] = (char) ('0' + k);
				if (!judge(board, i, j)) {
					continue;
				}
				if (j == 8) {
					if (dfs(board, i + 1, 0)) {
						return true;
					}
				} else {
					if (dfs(board, i, j + 1)) {
						return true;
					}
				}
			}
			board[i][j] = '.';
		} else {
			if (!judge(board, i, j)) {
				return false;
			}
			if (j == 8) {
				if (dfs(board, i + 1, 0)) {
					return true;
				}
			} else {
				if (dfs(board, i, j + 1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean judge(char[][] board, int i, int j) {
		for (int k = 0; k < 9; k++) {
			if (k != i && board[k][j] == board[i][j]) {
				return false;
			}
			if (k != j && board[i][k] == board[i][j]) {
				return false;
			}
			if (!(i == (i / 3 * 3 + k / 3) && j == (j / 3 * 3 + k % 3))
					&& board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] == board[i][j]) {
				return false;
			}
		}
		return true;
	}
}

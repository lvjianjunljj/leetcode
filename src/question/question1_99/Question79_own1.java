package question.question1_99;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
//用回溯法一做就出来了，并不难
public class Question79_own1 {
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0)
			return true;
		int m = board.length;
		if (m == 0)
			return word.equals("");
		int n = board[0].length;
		boolean[][] used = new boolean[m + 2][n + 2];
		for (int i = 0; i < m + 2; i++)
			used[i][0] = used[i][n + 1] = true;
		for (int i = 0; i < n + 2; i++)
			used[0][i] = used[m + 1][i] = true;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (board[i][j] == word.charAt(0))
					if (dfs(board, used, word, 1, i, j))
						return true;
		return false;
	}

	private boolean dfs(char[][] board, boolean[][] used, String word, int len,
			int i, int j) {
		used[i + 1][j + 1] = true;
		if (len == word.length())
			return true;
		if (!used[i + 2][j + 1] && board[i + 1][j] == word.charAt(len)
				&& dfs(board, used, word, len + 1, i + 1, j))
			return true;
		if (!used[i + 1][j + 2] && board[i][j + 1] == word.charAt(len)
				&& dfs(board, used, word, len + 1, i, j + 1))
			return true;
		if (!used[i][j + 1] && board[i - 1][j] == word.charAt(len)
				&& dfs(board, used, word, len + 1, i - 1, j))
			return true;
		if (!used[i + 1][j] && board[i][j - 1] == word.charAt(len)
				&& dfs(board, used, word, len + 1, i, j - 1))
			return true;
		used[i + 1][j + 1] = false;
		return false;
	}
}

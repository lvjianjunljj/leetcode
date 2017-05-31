package question.question1_99;
//在others的基础上对代码进行进一步的优化
public class Question79_own2 {
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0)
			return true;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (dfs(board, word, 0, i, j))
					return true;
		return false;
	}

	private boolean dfs(char[][] board, String word, int len, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| board[i][j] != word.charAt(len))
			return false;
		board[i][j] += 256;
		if (len == word.length() - 1)
			return true;
		if (dfs(board, word, len + 1, i + 1, j)
				|| dfs(board, word, len + 1, i, j + 1)
				|| dfs(board, word, len + 1, i - 1, j)
				|| dfs(board, word, len + 1, i, j - 1))
			return true;
		board[i][j] -= 256;
		return false;
	}
}

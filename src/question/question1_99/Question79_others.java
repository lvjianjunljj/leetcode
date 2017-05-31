package question.question1_99;
//改进了一下代码，通过对board本身进行修改和复原可以省略对于数组used的维护
public class Question79_others {
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0)
			return true;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (board[i][j] == word.charAt(0) && dfs(board, word, 1, i, j))
					return true;
		return false;
	}

	private boolean dfs(char[][] board, String word, int len, int i, int j) {
		board[i][j] += 256;
		if (len == word.length())
			return true;
		if (i < board.length - 1 && board[i + 1][j] == word.charAt(len)
				&& dfs(board, word, len + 1, i + 1, j))
			return true;
		if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(len)
				&& dfs(board, word, len + 1, i, j + 1))
			return true;
		if (i > 0 && board[i - 1][j] == word.charAt(len)
				&& dfs(board, word, len + 1, i - 1, j))
			return true;
		if (j > 0 && board[i][j - 1] == word.charAt(len)
				&& dfs(board, word, len + 1, i, j - 1))
			return true;
		board[i][j] -= 256;
		return false;
	}
}

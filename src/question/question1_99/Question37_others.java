package question.question1_99;

//根据答案给的方法重新修改了一下自己的判断方法isValidSudoku——耗时降低了很多，确实还不错，这道题就这样吧
public class Question37_others {
	public boolean solveSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						board[i][j] = c;
						if (isValidSudoku(board, i, j, c) && solveSudoku(board))
							return true;
						else
							board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidSudoku(char[][] board, int i, int j, char c) {
		for (int k = 0; k < 9; k++)
			if ((k != j && board[i][k] == c) || ((k != i && board[k][j] == c)))
				return false;
		int x = i / 3 * 3, y = j / 3 * 3;
		for (int m = 0; m < 3; m++)
			for (int n = 0; n < 3; n++)
				if (!(x + m == i && y + n == j) && board[x + m][y + n] == c)
					return false;
		return true;
	}
}

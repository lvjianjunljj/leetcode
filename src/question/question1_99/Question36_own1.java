package question.question1_99;

import java.util.HashSet;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

//判断一个未填满的数独是否是符合规则的——并不一定是有解的，只是符合规则，很简单
public class Question36_own1 {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> row = new HashSet<Character>();
			HashSet<Character> col = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !col.add(board[j][i]))
					return false;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				HashSet<Character> block = new HashSet<Character>();
				for (int m = 0; m < 3; m++)
					for (int n = 0; n < 3; n++)
						if (board[i * 3 + m][j * 3 + n] != '.'
								&& !block.add(board[i * 3 + m][j * 3 + n]))
							return false;
			}
		}
		return true;
	}
}

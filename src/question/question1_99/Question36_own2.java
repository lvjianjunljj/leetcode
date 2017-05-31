package question.question1_99;

import java.util.HashSet;

//想着如果只遍历一遍耗时会不会变低，然而并没有
public class Question36_own2 {
	public boolean isValidSudoku(char[][] board) {
		HashSet[] list = new HashSet[27];
		for (int i = 0; i < 27; i++)
			list[i] = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				if (!(list[i].add(board[i][j]) && list[j + 9].add(board[i][j]) && list[j
						/ 3 * 3 + i / 3 + 18].add(board[i][j])))
					return false;
			}
		}
		return true;
	}
}

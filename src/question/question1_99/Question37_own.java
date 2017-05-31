package question.question1_99;

/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 */
import java.util.HashSet;

//调用了36的方法，对于回溯一定要有最后将其剔除（或者是设置为原值，对于本题是将为'.'的点重新设置为'.'）的过程
//同时对于比较复杂的回溯（一般是用回溯列举所有的情况求可行解的题而不是类似全排列得体）一般递归的方法是要有返回值的
//对于leetcode如果主方法返回值为空，只要主方法名不变增加返回值也没有关系
//这道题的主方法一开始就是public void solveSudoku(char[][] board)，改成这样也行
public class Question37_own {
	public boolean solveSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						board[i][j] = c;
						if (isValidSudoku(board) && solveSudoku(board))
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

	private boolean isValidSudoku(char[][] board) {
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

package question.question400_499;

//这个方法对有些输入确实不对，想法也确实有问题，但是居然能通过，不知道为什么
public class Question419_others {
	public int countBattleships(char[][] board) {
		int m = board.length;
		if (m == 0) {
			return 0;
		}
		int n = board[0].length;
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (i > 0 && board[i - 1][j] == 'X') {
					continue;
				}
				if (j > 0 && board[i][j - 1] == 'X') {
					continue;
				}
				res++;
			}
		}
		return res;
	}
}a

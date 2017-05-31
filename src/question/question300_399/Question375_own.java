package question.question300_399;

/*
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * Example:
 * n = 10, I pick 8.
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * Game over. 8 is the number I picked.
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */

//这道题的意思是根据不同的输入n，有不同的guess方法使得最大可能花费最小化——比如对于n = 4你就会猜1和3而不是2和3.
//用这种动态规划做就不用想太多了，就直接做就行了。没意思
public class Question375_own {
	public int getMoneyAmount(int n) {
		int[][] data = new int[n][n];
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (j == i - 1)
					data[j][i] = j + 1;
				else {
					data[j][i] = Integer.MAX_VALUE;
					for (int k = j + 1; k < i; k++)
						data[j][i] = Math.min(data[j][i], Math.max(
								data[j][k - 1], data[k + 1][i])
								+ k + 1);
				}
			}
		}
		return data[0][n - 1];
	}
}

package question.question400_499;

/**
 * @author lvjj
 * @date 2017年4月22日 Given an array of scores that are non-negative integers.
 *       Player 1 picks one of the numbers from either end of the array followed
 *       by the player 2 and then player 1 and so on. Each time a player picks a
 *       number, that number will not be available for the next player. This
 *       continues until all the scores have been chosen. The player with the
 *       maximum score wins.
 * 
 *       Given an array of scores, predict whether player 1 is the winner. You
 *       can assume each player plays to maximize his score.
 * 
 *       Example 1: Input: [1, 5, 2] Output: False Explanation: Initially,
 *       player 1 can choose between 1 and 2. If he chooses 2 (or 1), then
 *       player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then
 *       player 1 will be left with 1 (or 2). So, final score of player 1 is 1 +
 *       2 = 3, and player 2 is 5. Hence, player 1 will never be the winner and
 *       you need to return False. Example 2: Input: [1, 5, 233, 7] Output: True
 *       Explanation: Player 1 first chooses 1. Then player 2 have to choose
 *       between 5 and 7. No matter which number player 2 choose, player 1 can
 *       choose 233. Finally, player 1 has more score (234) than player 2 (12),
 *       so you need to return True representing player1 can win. Note: 1 <=
 *       length of the array <= 20. Any scores in the given array are
 *       non-negative integers and will not exceed 10,000,000. If the scores of
 *       both players are equal, then player 1 is still the winner.
 * 
 */
public class Question486_own {
	//做过这道题，所以写起来很快
	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
		if (n < 1) {
			return false;
		}
		int sum = 0;
		int[][] min = new int[n][n];
		int[][] max = new int[n][n];
		for (int i = 0; i < n; i++) {
			max[i][i] = nums[i];
			sum += nums[i];
		}
		for (int j = 0; j < n; j++) {
			for (int i = j - 1; i >= 0; i--) {
				max[i][j] = Math.max(nums[i] + min[i + 1][j], nums[j] + min[i][j - 1]);
				min[i][j] = Math.min(max[i + 1][j], max[i][j - 1]);
			}
		}
		// 平了也算赢
		return max[0][n - 1] >= (sum + 1) / 2;
	}
}

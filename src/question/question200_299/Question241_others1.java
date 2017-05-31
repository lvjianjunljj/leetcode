package question.question200_299;

import java.util.ArrayList;
import java.util.List;

//思路都是一样的，这个写法太麻烦了，封装的也不好，不看了，没意思
public class Question241_others1 {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();
		if (input == null || input.length() == 0)
			return result;
		List<String> ops = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			int j = i;
			while (j < input.length() && Character.isDigit(input.charAt(j)))
				j++;
			ops.add(input.substring(i, j));
			if (j != input.length())
				ops.add(input.substring(j, j + 1));
			i = j;
		}
		int N = (ops.size() + 1) / 2; // num of integers
		ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
		for (int d = 0; d < N; d++) {
			if (d == 0) {
				for (int i = 0; i < N; i++) {
					dp[i][i] = new ArrayList<Integer>();
					dp[i][i].add(Integer.valueOf(ops.get(i * 2)));
				}
				continue;
			}
			for (int i = 0; i < N - d; i++) {
				dp[i][i + d] = new ArrayList<Integer>();
				for (int j = i; j < i + d; j++) {
					ArrayList<Integer> left = dp[i][j], right = dp[j + 1][i + d];
					String operator = ops.get(j * 2 + 1);
					for (int leftNum : left)
						for (int rightNum : right) {
							if (operator.equals("+"))
								dp[i][i + d].add(leftNum + rightNum);
							else if (operator.equals("-"))
								dp[i][i + d].add(leftNum - rightNum);
							else
								dp[i][i + d].add(leftNum * rightNum);
						}
				}
			}
		}
		return dp[0][N - 1];
	}
}

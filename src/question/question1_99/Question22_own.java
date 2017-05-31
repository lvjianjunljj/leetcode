package question.question1_99;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
import java.util.ArrayList;
import java.util.List;

//用回溯做，这道题分分钟就出来了
public class Question22_own {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		dfs(res, new StringBuilder(), 0, 0, n);
		return res;
	}

	private void dfs(List<String> res, StringBuilder path, int i, int j, int n) {
		if (i == n && j == n)
			res.add(path.toString());
		if (j > i || i > n || j > n)
			return;
		path.append("(");
		dfs(res, path, i + 1, j, n);
		path.deleteCharAt(path.length() - 1);
		path.append(")");
		dfs(res, path, i, j + 1, n);
		path.deleteCharAt(path.length() - 1);
	}
}

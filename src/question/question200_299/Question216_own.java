package question.question200_299;

/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
import java.util.ArrayList;
import java.util.List;
//和question39与40是一类题  回溯法很简单
public class Question216_own {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, new ArrayList<Integer>(), 0, 0, 1, k, n);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> path, int sum,
			int count, int index, int k, int n) {
		if (count > k || sum > n)
			return;
		if (sum == n && count == k)
			res.add(new ArrayList<Integer>(path));
		if (sum < n) {
			for (int i = index; i < 10; i++) {
				path.add(i);
				dfs(res, path, sum + i, count + 1, i + 1, k, n);
				path.remove(path.size() - 1);
			}
		}
	}
}

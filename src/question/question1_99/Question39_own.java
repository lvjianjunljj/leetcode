package question.question1_99;

/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 [
 [7],
 [2, 2, 3]
 ]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//这也是最简单的回溯法，数据已经排好序了，所以并不麻烦。
public class Question39_own {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		dfs(res, candidates, new ArrayList<Integer>(), 0, 0, target);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] candidates,
			List<Integer> path, int index, int sum, int target) {
		if (sum == target) {
			res.add(new ArrayList<Integer>(path));
		} else if (sum < target) {
			for (int i = index; i < candidates.length; i++) {
				path.add(candidates[i]);
				dfs(res, candidates, path, i, sum + candidates[i], target);
				path.remove(path.size() - 1);
			}
		}
	}
}

package question.question1_99;

/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//根据question39的想法加一个判断就可以了
public class Question40_own {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		dfs(res, candidates, new ArrayList<Integer>(), 0, 0, target);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] candidates,
			List<Integer> path, int sum, int index, int target) {
		if (sum == target)
			res.add(new ArrayList<Integer>(path));
		else if (sum < target) {
			for (int i = index; i < candidates.length; i++) {
				if (i > index && candidates[i] == candidates[i - 1])
					continue;
				path.add(candidates[i]);
				dfs(res, candidates, path, sum + candidates[i], i + 1, target);
				path.remove(path.size() - 1);
			}
		}
	}
}

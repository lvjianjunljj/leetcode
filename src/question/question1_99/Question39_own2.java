package question.question1_99;

import java.util.ArrayList;
import java.util.List;

//其实根本没有必要排序
public class Question39_own2 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, new ArrayList<Integer>(), candidates, 0, 0, target);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> list,
			int[] candidates, int sum, int index, int target) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			res.add(new ArrayList(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs(res, list, candidates, sum + candidates[i], i, target);
			list.remove(list.size() - 1);
		}
	}
}

package question.question1_99;

/*
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
import java.util.ArrayList;
import java.util.List;

//这种全排列的题感觉还是要维护一个boolean数组
public class Question46_others1 {
	public List<List<Integer>> permute(int[] nums) {
		boolean[] used = new boolean[nums.length];
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, nums, used, new ArrayList<Integer>(), 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] nums, boolean[] used,
			List<Integer> path, int count) {
		if (count == nums.length)
			res.add(new ArrayList<Integer>(path));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (!used[i]) {
					used[i] = true;
					path.add(nums[i]);
					dfs(res, nums, used, path, count + 1);
					path.remove(path.size() - 1);
					used[i] = false;
				}
			}
		}
	}
}

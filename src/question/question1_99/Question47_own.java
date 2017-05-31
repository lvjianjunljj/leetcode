package question.question1_99;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//仿照46题写的，用HashSet才不会超时，写的简直是不合题意
public class Question47_own {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean[] used = new boolean[nums.length];
		HashSet<List<Integer>> data = new HashSet<List<Integer>>();
		dfs(data, nums, used, new ArrayList<Integer>(), 0);
		for (List<Integer> list : data)
			res.add(list);
		return res;
	}

	private void dfs(HashSet<List<Integer>> data, int[] nums, boolean[] used,
			List<Integer> path, int count) {
		if (count == nums.length && (!data.contains(path)))
			data.add(new ArrayList<Integer>(path));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (!used[i]) {
					used[i] = true;
					path.add(nums[i]);
					dfs(data, nums, used, path, count + 1);
					path.remove(path.size() - 1);
					used[i] = false;
				}
			}
		}
	}
}

package question.question1_99;

/*
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
import java.util.ArrayList;
import java.util.List;
//最简单的一道回溯的题，一定要掌握好这种方法，还是很管用的
public class Question78_others1 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, nums, new ArrayList<Integer>(), 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] nums,
			List<Integer> element, int index) {
		res.add(new ArrayList<Integer>(element));
		for (int i = index; i < nums.length; i++) {
			element.add(nums[i]);
			dfs(res, nums, element, i + 1);
			element.remove(element.size() - 1);
		}
	}
}

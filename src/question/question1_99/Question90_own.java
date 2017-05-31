package question.question1_99;

/*
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//仿照question78的方法，加了一个判断重复的方法，耗时简直是高，不可取
public class Question90_own {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, nums, new ArrayList<Integer>(), 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] nums,
			List<Integer> element, int index) {
		if (res.indexOf(element) < 0)
			res.add(new ArrayList<Integer>(element));
		for (int i = index; i < nums.length; i++) {
			element.add(nums[i]);
			dfs(res, nums, element, i + 1);
			element.remove(element.size() - 1);
		}
	}
}

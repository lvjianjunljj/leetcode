package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//这才是正统的回溯的方法
public class Question90_others1 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, nums, new ArrayList<Integer>(), 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] nums,
			List<Integer> element, int index) {
		res.add(new ArrayList<Integer>(element));
		for (int i = index; i < nums.length; i++) {
			if (i <= index || nums[i] != nums[i - 1]) {
				element.add(nums[i]);
				dfs(res, nums, element, i + 1);
				element.remove(element.size() - 1);
			}
		}
	}
}

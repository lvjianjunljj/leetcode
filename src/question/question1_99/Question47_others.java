package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//加的这一个判断条件非常巧妙，简直是佩服。
public class Question47_others {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		dfs(res, nums, used, new ArrayList<Integer>(), 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] nums, boolean[] used,
			List<Integer> path, int count) {
		if (count == nums.length)
			res.add(new ArrayList<Integer>(path));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i])
					continue;
				//这一步判断简直是美妙——奉为神作啊
				if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
					continue;
				path.add(nums[i]);
				used[i] = true;
				dfs(res, nums, used, path, count + 1);
				used[i] = false;
				path.remove(path.size() - 1);
			}
		}
	}
}

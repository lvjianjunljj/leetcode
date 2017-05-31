package question.question1_99;

import java.util.ArrayList;
import java.util.List;
//不需要维护used数组的方法，在原有的path上向里面插空加入下一个值
public class Question46_others2 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, nums, new ArrayList<Integer>(), 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] nums, List<Integer> path,
			int th) {
		if (th == nums.length)
			res.add(new ArrayList<Integer>(path));
		else {
			for (int i = 0; i <= path.size(); i++) {
				path.add(i, nums[th]);
				dfs(res, nums, path, th + 1);
				path.remove(i);
			}
		}
	}
}

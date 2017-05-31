package question.question1_99;

import java.util.ArrayList;
import java.util.List;

//其实完全不用递归就能做
public class Question46_own {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return res;
		}
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> next = new ArrayList<List<Integer>>();
			for (List<Integer> list : res) {
				for (int j = 0; j <= i; j++) {
					list.add(j, nums[i]);
					next.add(new ArrayList<Integer>(list));
					list.remove(j);
				}
			}
			res = next;
		}
		return res;
	}
}

package question.question1_99;

import java.util.ArrayList;
import java.util.List;
//这个方法相比回溯确实巧妙一点，满分。。。
public class Question78_others2 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> element = new ArrayList<List<Integer>>();
			for (List<Integer> list : res) {
				List<Integer> array = new ArrayList<Integer>(list);
				array.add(nums[i]);
				element.add(array);
			}
			res.addAll(element);
		}
		return res;
	}
}

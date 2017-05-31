package question.question1_99;

import java.util.ArrayList;
import java.util.List;
//用位运算实现想法——每一个数都有有和没有两种情况
//其实others2和others3才是一开始用数学思维能想到的方法
public class Question78_others3 {
	public List<List<Integer>> subsets(int[] nums) {
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < Math.pow(2, n); i++) {
			List<Integer> element = new ArrayList<Integer>();
			int k = i;
			for (int j = 0; j < n; j++) {
				if ((k & 1) != 0)
					element.add(nums[j]);
				k >>= 1;
			}
			res.add(element);
		}
		return res;
	}
}

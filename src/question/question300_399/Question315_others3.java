package question.question300_399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//indexedTree方法，暂时还没掌握
public class Question315_others3 {
	class BinaryIndexedTree {
		int[] sums;

		public BinaryIndexedTree(int n) {
			sums = new int[n + 1];
		}

		public void update(int i) {
			while (i < sums.length) {
				sums[i] += 1;
				i += (i & -i);
			}
		}

		public int sum(int i) {
			int r = 0;
			while (i > 0) {
				r += sums[i];
				i -= (i & -i);
			}
			return r;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums)
			set.add(i);
		int[] tmp = new int[set.size()];
		int k = 0, s = 0;
		for (int i : set)
			tmp[k++] = i;
		Arrays.sort(tmp);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : tmp)
			map.put(i, s++);
		List<Integer> res = new ArrayList<Integer>();
		BinaryIndexedTree tree = new BinaryIndexedTree(map.size());
		for (int i = nums.length - 1; i >= 0; i--) {
			res.add(0, tree.sum(map.get(nums[i])));
			tree.update(map.get(nums[i]) + 1);
		}
		return res;
	}
}a

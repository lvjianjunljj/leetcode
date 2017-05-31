package question.question100_199;

import java.util.HashSet;

public class Question128_HashSet {
	public int longestConsecutive(int[] nums) {
		int result = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		for (int i : nums) {
			int mark = 0;
			if (set.contains(i)) {
				int j = i;
				while (set.contains(j)) {
					mark++;
					set.remove(j);
					j++;
				}
				j = i - 1;
				while (set.contains(j)) {
					mark++;
					set.remove(j);
					j--;
				}
			}
			if (result < mark) {
				result = mark;
			}
		}
		return result;
	}
}

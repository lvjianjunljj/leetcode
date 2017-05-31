package question.question200_299;

/*
 * Given an array of integers, find out whether there are two distinct indices i and j 
 * in the array such that the difference between nums[i] and nums[j] is at most t 
 * and the difference between i and j is at most k.
 */
import java.util.HashSet;
//针对该题的输入特性做的对应方法，当数据量极大的时候，题目给的t的值都是小于等于0的，所以可以省略遍历HashSet的步骤
//用到了Question219_others1的简炼的方法，果然美妙啊
public class Question220_own {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				set.remove(nums[i - k - 1]);
			if (t > 0)
				for (int j : set)
					if (Math.max(j, nums[i]) - Math.min(j, nums[i]) >= 0
							&& Math.max(j, nums[i]) - Math.min(j, nums[i]) <= t)
						return true;
			if (!set.add(nums[i]) && t >= 0)
				return true;
		}
		return false;
	}
}

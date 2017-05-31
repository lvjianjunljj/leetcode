package question.question200_299;

/*
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and 
 * the difference between i and j is at most k.
 */
import java.util.HashSet;
//用HashSet做还是很快的，既然有间距限制，那就到了最大间距一边剔除值，一边加一个值
public class Question219_own {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		int n = nums.length;
		if (k == 0 || n == 0)
			return false;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < Math.min(k, n); i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		if (n <= k)
			return false;
		for (int i = 0; i < n - k; i++) {
			//利用add方法有boolean返回值对代码稍作改进——降低了一点点耗时
			if (!set.add(nums[k + i]))
				return true;
			set.remove(nums[i]);
		}
		return false;
	}
}

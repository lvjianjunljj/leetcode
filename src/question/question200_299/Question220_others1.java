package question.question200_299;

import java.util.HashMap;
//用了bucket，将所有的数对（t + 1）进行求商，相同的放在一个桶中，
//循环的过程中一个桶中存在两个数或者相邻两个桶中的数符合要求便能返回true。
//类似的判断两个数的differ小于某个数的题都可以用这种思想
public class Question220_others1 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				map.remove(((long) nums[i - k - 1] - Integer.MIN_VALUE)
						/ ((long) t + 1));
			long num = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = num / ((long) t + 1);
			if (map.containsKey(bucket)
					|| (map.containsKey(bucket - 1) && num
							- map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1)
							- num <= t))
				return true;
			map.put(bucket, num);
		}
		return false;
	}
}

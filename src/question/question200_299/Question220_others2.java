package question.question200_299;

import java.util.TreeSet;
//用TreeSet就没什么意思了啊
public class Question220_others2 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        final TreeSet<Integer> values = new TreeSet<Integer>();
        for (int ind = 0; ind < nums.length; ind++) {
        	//利用TreeSet的方法——简直了floor返回比输入小的最大值，ceiling返回比输入大的最小值——根本就不用自己做什么了
            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }
            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }
}

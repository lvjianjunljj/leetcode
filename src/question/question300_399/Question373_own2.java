package question.question300_399;

import java.util.ArrayList;
import java.util.List;

//通过维护一个index数组（index[i]对应nums1[i]对应到了nums2的第几位）
//使得每次找下一个数的时候只需要遍历一遍n（n为长度较小的数组的长度）
public class Question373_own2 {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		k = Math.min(nums1.length * nums2.length, k);
		boolean turn = false;
		if (nums1.length > nums2.length) {
			turn = true;
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}
		List<int[]> res = new ArrayList<int[]>();
		if (nums2.length == 0)
			return res;
		int[] index = new int[nums1.length];
		while (k > 0) {
			int element = Integer.MAX_VALUE;
			int ind = 0;
			for (int i = 0; i < index.length; i++) {
				if (index[i] < nums2.length) {
					if (element > nums1[i] + nums2[index[i]]) {
						element = nums1[i] + nums2[index[i]];
						ind = i;
					}
				}
			}
			if (turn)
				res.add(new int[] { nums2[index[ind]], nums1[ind] });
			else
				res.add(new int[] { nums1[ind], nums2[index[ind]] });
			index[ind]++;

			k--;
		}
		return res;
	}
}

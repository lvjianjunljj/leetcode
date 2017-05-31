package question.question100_199;
/*
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
import java.util.Arrays;
//这道题想在线性时间内完成就只能通过桶排序了，设置n - 1个桶这样想要的结果一定是桶与桶之间的max和min的差值了
//同时数组的max和min要分开计算
public class Question164_others1 {
	public int maximumGap(int[] nums) {
		int n = nums.length;
		if (n < 2)
			return 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		int gap = (int) Math.ceil((double) (max - min) / (n - 1));
		int[] minBucket = new int[n - 1];
		int[] maxBucket = new int[n - 1];
		Arrays.fill(minBucket, Integer.MAX_VALUE);
		Arrays.fill(maxBucket, Integer.MIN_VALUE);
		for (int i : nums) {
			if (i == min || i == max)
				continue;
			int index = (i - min) / gap;
			minBucket[index] = Math.min(minBucket[index], i);
			maxBucket[index] = Math.max(maxBucket[index], i);
		}
		int prev = min, res = 0;
		for (int i = 0; i < n - 1; i++) {
			if (minBucket[i] == Integer.MAX_VALUE)
				continue;
			res = Math.max(res, minBucket[i] - prev);
			prev = maxBucket[i];
		}
		res = Math.max(res, max - prev);
		return res;
	}
}

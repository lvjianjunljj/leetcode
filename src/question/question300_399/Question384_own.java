package question.question300_399;

/*
 * Shuffle a set of numbers without duplicates.
 * Example:
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] 
 * must equally likely to be returned.
 * solution.shuffle();
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
import java.util.HashSet;
import java.util.Random;

//HashSet存储数据并不是真正意义的随机，而是按照Hashcode的方式的顺序存储（并不是随机）
//所以想随机取出数组中的数只能在取出的过程中构造一个随机数作为index了
public class Question384_own {
	int n = 0;
	int[] nums;

	public Question384_own(int[] nums) {
		n = nums.length;
		this.nums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] shu = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		Random ra = new Random();
		for (int i : nums)
			set.add(i);
		int k = 0;
		while (!set.isEmpty()) {
			int index = ra.nextInt(n);
			if (set.contains(nums[index])) {
				set.remove(nums[index]);
				shu[k++] = nums[index];
			}
		}
		return shu;
	}
}

package question.question300_399;

/*
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. 
 * You can assume that the given target number must exist in the array.
 *Note:
 *The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *Example:
 *int[] nums = new int[] {1,2,3,3,3};
 *Solution solution = new Solution(nums);
 *pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 *solution.pick(3);
 *pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 *solution.pick(1);
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//看Note我以为这种方法会MLE——但是并没有，那就没有意思了，太简单了，把相同的数的index存到一个数组
//然后将所有的数据用map队形起来
public class Question398_own1 {

	HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

	public Question398_own1(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], new ArrayList<Integer>());
			map.get(nums[i]).add(i);
		}
	}

	public int pick(int target) {
		List<Integer> index = map.get(target);
		Random ra = new Random();
		return index.get(ra.nextInt(index.size()));
	}
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int param_1 = obj.pick(target);
 */

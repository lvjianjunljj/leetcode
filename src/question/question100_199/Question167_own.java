package question.question100_199;

/*
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
//我遍历了一个数组，对于对二个数组用了binary search，耗时也不是很高
public class Question167_own {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		int n = numbers.length;
		for (int i = 0; i < n - 1; i++) {
			int j = search(numbers, target - numbers[i], i + 1, n - 1);
			if (j >= 0) {
				res[0] = i + 1;
				res[1] = j + 1;
			}
		}
		return res;
	}

	private int search(int[] numbers, int target, int i, int j) {
		if (i > j)
			return -1;
		int mid = (i + j) / 2;
		if (numbers[mid] == target)
			return mid;
		else if (numbers[mid] > target)
			return search(numbers, target, i, mid - 1);
		else
			return search(numbers, target, mid + 1, j);
	}
}

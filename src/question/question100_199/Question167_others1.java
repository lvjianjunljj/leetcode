package question.question100_199;

//完全可以根据240的思路来做——右上角的坐标对应两个点分别在头和尾
//对于这种two point的题，一定要有这方面的想法，不能看过就忘了
public class Question167_others1 {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		int left = 0, right = numbers.length - 1;
		while (left <= right) {
			int tmp = numbers[left] + numbers[right];
			if (tmp == target) {
				res[0] = left + 1;
				res[1] = right + 1;
				return res;
			} else if (tmp > target)
				right--;
			else
				left++;
		}
		return res;
	}
}

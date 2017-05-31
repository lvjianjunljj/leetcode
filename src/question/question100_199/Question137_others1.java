package question.question100_199;

/*
 * First time number appear -> save it in "ones"
 * Second time -> clear "ones" but save it in "twos" for later check
 * Third time -> try to save in "ones" but value saved in "twos" clear it.
 * 这方法简直是美妙。。。
 */
public class Question137_others1 {
	public int singleNumber(int[] nums) {
		int one = 0, two = 0;
		for (int i : nums) {
			one ^= i & ~two;
			two ^= i & ~one;
		}
		return one;
	}
}

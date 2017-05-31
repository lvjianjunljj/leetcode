package question.question300_399;

//想法确实很巧妙——在保证small小于big且small在big前面的前提下找到一个i比small和big都大则返回true否则返回false
public class Question334_others {
	public boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int i : nums) {
			if (i <= small)
				small = i;
			else if (i <= big)
				big = i;
			else
				return true;
		}
		return false;
	}
}

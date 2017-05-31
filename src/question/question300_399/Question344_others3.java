package question.question300_399;
//虽然耗时很高，但是本身这种递归的想法还是非常新颖的
public class Question344_others3 {
	public String reverseString(String s) {
		int length = s.length();
		if (length <= 1)
			return s;
		String leftStr = s.substring(0, length / 2);
		String rightStr = s.substring(length / 2, length);
		return reverseString(rightStr) + reverseString(leftStr);
	}
}

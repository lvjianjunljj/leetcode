package question.question300_399;

//看了提示以后想到这道题完全可以用位运算来做，但是相比于own2也不能提高太多耗时——但代码精简了很多
public class Question389_own3 {
	public char findTheDifference(String s, String t) {
		int count = 0;
		for (int i = 0; i < t.length(); i++)
			count ^= (t.charAt(i) - 'a');
		for (int i = 0; i < s.length(); i++)
			count ^= (s.charAt(i) - 'a');
		return (char) (count + 'a');
	}
}

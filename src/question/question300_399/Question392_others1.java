package question.question300_399;

//其实思路和own中的two point是一样的，但是调用java封装好了的方法确实降低了耗时
public class Question392_others1 {
	public boolean isSubsequence(String s, String t) {
		if (s.length() > t.length())
			return false;
		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			prev = t.indexOf(c, prev);
			if (prev++ == -1)
				return false;
		}
		return true;
	}
}
a这道题答案中没有给DP和BST的做法，立个mark。过段时间再去看看有没有新的思路

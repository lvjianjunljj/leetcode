package question.question200_299;

//可以先得到j——j.s.substring(0, j)一定包含从最左端开始的最长回文，然后再递归调用原方法
//这个方法简直是巧妙，避免了多次重复调用判断回文的方法。
public class Question214_others1 {
	public String shortestPalindrome(String s) {
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--)
			if (s.charAt(i) == s.charAt(j))
				j++;
		if (j == s.length())
			return s;
		return new StringBuilder(s.substring(j)).reverse().toString()
				+ shortestPalindrome(s.substring(0, j)) + s.substring(j);
	}
}

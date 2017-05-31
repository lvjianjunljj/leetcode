package question.question400_499;

//根据答案的写法我修改了一下我的代码，最后这个判断的写法惊艳到我了，省去了对一个boolean值的维护和一些判断，还不错
public class Question409_others {
	public int longestPalindrome(String s) {
		int[] list = new int[58];
		for (int i = 0; i < s.length(); i++)
			list[s.charAt(i) - 'A']++;
		int res = 0;
		for (int i = 0; i < 58; i++) {
			if (list[i] % 2 == 0)
				res += list[i];
			else
				res += list[i] - 1;
		}
		return res == s.length() ? res : res + 1;
	}
}

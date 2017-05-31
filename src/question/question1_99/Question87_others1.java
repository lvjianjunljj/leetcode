package question.question1_99;

//递归调用其本身才是最快的方法，直接比较s1和s2才比较快
public class Question87_others1 {
	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		if (s1.length() != s2.length())
			return false;
		int[] tmp = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			tmp[s1.charAt(i) - 'a']++;
			tmp[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++)
			if (tmp[i] != 0)
				return false;
		for (int i = 1; i < s1.length(); i++)
			if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(
					s1.substring(i), s2.substring(i)))
					|| (isScramble(s1.substring(0, i), s2.substring(s1.length()
							- i)) && isScramble(s1.substring(i), s2.substring(
							0, s1.length() - i))))
				return true;
		return false;
	}
}

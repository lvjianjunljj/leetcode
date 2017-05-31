package question.question1_99;

//回溯果然超时了
public class Question44_own1 {
	public boolean isMatch(String s, String p) {
		p = p.replaceAll("\\*+", "*");
		char[] sList = s.toCharArray();
		char[] pList = p.toCharArray();
		return judge(sList, pList, 0, 0);
	}

	private boolean judge(char[] s, char[] p, int i, int j) {
		if (i == s.length && j == p.length)
			return true;
		if (i < s.length && j == p.length)
			return false;
		if (i == s.length && j < p.length && p[j] != '*')
			return false;
		if (i == s.length && j < p.length && p[j] == '*')
			return judge(s, p, i, j + 1);
		if (p[j] == '?' || s[i] == p[j])
			return judge(s, p, i + 1, j + 1);
		else if (p[j] == '*') {
			for (int k = i; k <= s.length; k++) {
				if (judge(s, p, k, j + 1))
					return true;
			}
			return false;
		} else {
			return false;
		}
	}
}a

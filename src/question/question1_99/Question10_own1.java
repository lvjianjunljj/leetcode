package question.question1_99;

/*
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */

//这道题用正则匹配就能做的——相比之下44题就没法用正则匹配做——不知道怎么匹配任意一段字符串
//用回溯或者动态规划应该也能做，但是我没细作，以后再说吧
public class Question10_own1 {
	public boolean isMatch(String s, String p) {
		if (s.equals("")) {
			p = p.replaceAll("[a-z]\\*", "");
			p = p.replaceAll("\\.\\*", "");
			return p.equals("");
		}
		return s.replaceFirst(p, "").equals("");
	}
}a

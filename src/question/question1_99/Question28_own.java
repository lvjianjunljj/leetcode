package question.question1_99;

/*
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

//没说任何要求，那就用Omn的时间复杂度一点一点地比较就好了，耗时也不是很长——老子从网上找的KMP做这道题简直一坨屎
public class Question28_own {
	public int strStr(String haystack, String needle) {
		for (int i = 0; i <= haystack.length() - needle.length(); i++)
			if (judge(haystack, needle, i))
				return i;
		return -1;
	}

	private boolean judge(String haystack, String needle, int index) {
		for (int i = 0; i < needle.length(); i++)
			if (haystack.charAt(index + i) != needle.charAt(i))
				return false;
		return true;
	}
}

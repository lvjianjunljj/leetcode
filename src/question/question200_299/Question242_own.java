package question.question200_299;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
import java.util.Arrays;

public class Question242_own {
	public boolean isAnagram(String s, String t) {
		char[] list1 = s.toCharArray();
		char[] list2 = t.toCharArray();
		Arrays.sort(list1);
		Arrays.sort(list2);
		if (list1.length != list2.length)
			return false;
		for (int i = 0; i < list1.length; i++)
			if (list1[i] != list2[i])
				return false;
		return true;
	}
}

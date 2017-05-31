package question.question300_399;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//用最原始的方法，将所有的元音字母都存储在一个数组中
public class Question345_own1 {
	public String reverseVowels(String s) {
		HashSet<Character> dict = new HashSet<Character>();
		dict.add('a');
		dict.add('e');
		dict.add('i');
		dict.add('o');
		dict.add('u');
		dict.add('A');
		dict.add('E');
		dict.add('I');
		dict.add('O');
		dict.add('U');
		List<Character> element = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++)
			if (dict.contains(s.charAt(i)))
				element.add(s.charAt(i));
		if (element.size() == 0)
			return s;
		StringBuilder sb = new StringBuilder();
		int n = element.size() - 1;
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (j < element.size() && c == element.get(j)) {
				sb.append(element.get(n--));
				j++;
			} else
				sb.append(c);
		}
		return sb.toString();
		
		//以后再遇到这种题就用new String(char[])代替将char一个个用append加到StringBuild中然后toString了，这样确实耗时低一些
//		HashSet<Character> dict = new HashSet<Character>();
//		dict.add('a');
//		dict.add('e');
//		dict.add('i');
//		dict.add('o');
//		dict.add('u');
//		dict.add('A');
//		dict.add('E');
//		dict.add('I');
//		dict.add('O');
//		dict.add('U');
//		List<Character> element = new ArrayList<Character>();
//		for (int i = 0; i < s.length(); i++)
//			if (dict.contains(s.charAt(i)))
//				element.add(s.charAt(i));
//		if (element.size() == 0)
//			return s;
//		StringBuilder sb = new StringBuilder();
//		int n = element.size() - 1;
//		int j = 0;
//		char[] array = new char[s.length()];
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if (j < element.size() && c == element.get(j)) {
//				array[i] = element.get(n--);
//				j++;
//			} else
//				array[i] = c;
//		}
//		return new String(array);
	}
}

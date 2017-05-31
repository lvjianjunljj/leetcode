package question.question300_399;

//我能想到的一个比较快的方法，将每个字母表示成一个数，求其和表示一个字符串，减去另一个字符串的和就是多出来的字符所表示的数
public class Question389_own2 {
	public char findTheDifference(String s, String t) {
		int[] list = new int[26];
		for (int i = 0; i < 26; i++)
			list[i] = i;
		int count = 0;
		for (int i = 0; i < t.length(); i++)
			count += list[t.charAt(i) - 'a'];
		for (int i = 0; i < s.length(); i++)
			count -= list[s.charAt(i) - 'a'];
		return (char) (count + 'a');
	}
}

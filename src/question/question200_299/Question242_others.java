package question.question200_299;

//相比于own维护一个int[] alphabet = new int[26];数组精妙的多且时间复杂度降为了On
public class Question242_others {
	public boolean isAnagram(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++)
			alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			alphabet[t.charAt(i) - 'a']--;
		for (int i = 0; i < 26; i++)
			if (alphabet[i] != 0)
				return false;
		return true;
	}
}

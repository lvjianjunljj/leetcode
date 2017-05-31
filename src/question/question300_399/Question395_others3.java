package question.question300_399;

//这个方法没什么意思，优化了暴力破解，升高空间复杂度降低时间复杂度从On3到On2
public class Question395_others3 {
	public int longestSubstring(String s, int k) {
		if (s == null || s.length() < 1)
			return 0;

		int[][] letters = new int[26][s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			for (int c = 0; c < 26; c++) {
				letters[c][i + 1] = letters[c][i];
			}
			letters[s.charAt(i) - 'a'][i + 1] += 1;
		}
		// May also optimize by deleting letters entries with 0 at end

		int longest = 0;
		for (int start = 0; start < s.length(); start++) {
			if (longest >= s.length() - start)
				return longest;
			for (int end = s.length(); end > start; end--) {
				boolean works = true;
				for (int c = 0; c < 26; c++) {
					int num = letters[c][end] - letters[c][start];
					if (num < k && num > 0) {
						works = false;
						end = s.indexOf('a' + c, start) + 1;
						break;
					}
				}
				if (works) {
					if (end - start > longest)
						longest = end - start;
					break;
				}
			}
		}

		return longest;
	}
}a

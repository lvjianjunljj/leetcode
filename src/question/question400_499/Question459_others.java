package question.question400_499;

//用KMP的做法，还是挺难理解的
public class Question459_others {
	public boolean repeatedSubstringPattern(String str) {
		int n = str.length(), cur = 0, j = 1;
		int[] pattern = new int[n];
		pattern[0] = 0;

		while (j < n) {
			if (str.charAt(cur) == str.charAt(j)) {
				pattern[j++] = ++cur;
			} else {
				if (cur == 0)
					pattern[j++] = 0;
				else
					cur = pattern[cur - 1]; /*
											 * start from beginning of current
											 * matching pattern
											 */
			}
		}

		return (pattern[n - 1] > 0 && n % (n - pattern[n - 1]) == 0);
	}
}

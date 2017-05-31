package question.question100_199;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
//这种解法有点无聊，再看看有什么别的解法吗
public class Question125_own {
	public boolean isPalindrome(String s) {
		char[] list = s.toCharArray();
		int i = 0, j = list.length - 1;
		while (i < j) {
			if (!((list[i] >= 'A' && list[i] <= 'Z')
					|| (list[i] >= 'a' && list[i] <= 'z') || (list[i] >= '0' && list[i] <= '9')))
				i++;
			else if (!((list[j] >= 'A' && list[j] <= 'Z')
					|| (list[j] >= 'a' && list[j] <= 'z') || (list[j] >= '0' && list[j] <= '9')))
				j--;
			else if (list[i] == list[j]
					|| ((list[i] - list[j] == 32 || list[j] - list[i] == 32)
							&& list[i] <= 'z' && list[j] <= 'z'
							&& list[i] >= 'A' && list[j] >= 'A')) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}
}

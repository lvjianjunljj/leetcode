package question.question100_199;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
import java.util.ArrayList;
import java.util.List;
//标准的回溯法，加一个判断就行了
public class Question131_own1 {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(res, s, new ArrayList<String>(), 0, 0);
		return res;
	}

	private void dfs(List<List<String>> res, String s, List<String> path,
			int count, int index) {
		if (count == s.length())
			res.add(new ArrayList<String>(path));
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s, index, i + 1)) {
				path.add(s.substring(index, i + 1));
				dfs(res, s, path, count + i + 1 - index, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int i, int j) {
		String str = s.substring(i, j);
		char[] list = str.toCharArray();
		int n = list.length;
		for (int k = 0; k < n / 2; k++)
			if (list[k] != list[n - 1 - k])
				return false;
		return true;
	}
}

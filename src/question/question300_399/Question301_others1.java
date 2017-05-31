package question.question300_399;

/*
 * Remove the minimum number of invalid parentheses in order to make the input string valid. 
 * Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//我的思路和他是完全一样的，就是广度优先搜索，其中维护的这个found才是精髓，首先发现的就是长度最长的，之后就不用再截断了。
//但是我天真的以为自己用递归能实现BFS，我并不能。。。
public class Question301_others1 {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();
		HashSet<String> set = new HashSet<String>();
		queue.offer(s);
		set.add(s);
		boolean found = false;
		while (!queue.isEmpty()) {
			String tmp = queue.poll();
			if (isValid(tmp)) {
				res.add(tmp);
				found = true;
			}
			if (found)
				continue;
			for (int i = 0; i < tmp.length(); i++) {
				if (tmp.charAt(i) == '(' || tmp.charAt(i) == ')') {
					String next = tmp.substring(0, i) + tmp.substring(i + 1);
					if (!set.contains(next)) {
						queue.offer(next);
						set.add(next);
					}
				}
			}
		}
		return res;
	}

	private boolean isValid(String s) {
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				k++;
			else if (s.charAt(i) == ')' && k-- == 0)
				return false;
		}
		return k == 0;
	}
}

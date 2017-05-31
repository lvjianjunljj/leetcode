package question.question1_99;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
import java.util.Stack;

//一开始没想到用动态规划，果然我的带备忘录的动态规划使得还是溜啊。。。
public class Question97_own {
	public boolean isInterleave(String s1, String s2, String s3) {
		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();
		char[] array3 = s3.toCharArray();
		if (array1.length + array2.length != array3.length)
			return false;
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		Stack<Character> stack3 = new Stack<Character>();
		for (char i : array1)
			stack1.add(i);
		for (char i : array2)
			stack2.add(i);
		for (char i : array3)
			stack3.add(i);
		int m = array1.length;
		int n = array2.length;
		int[][] mark = new int[m][n];
		return aux(stack1, stack2, stack3, mark, m - 1, n - 1);

	}

	public static boolean aux(Stack<Character> stack1, Stack<Character> stack2,
			Stack<Character> stack3, int[][] mark, int i, int j) {
		if (stack1.isEmpty()) {
			while (!stack3.isEmpty()) {
				if (stack2.pop() != stack3.pop()) {
					return false;
				}
			}
			return true;
		}
		if (stack2.isEmpty()) {
			while (!stack3.isEmpty()) {
				if (stack1.pop() != stack3.pop()) {
					return false;
				}
			}
			return true;
		}
		if (i < 0 || j < 0)
			return false;
		if (mark[i][j] != 0)
			return mark[i][j] == 1;
		if (stack3.peek() == stack1.peek() && stack3.peek() != stack2.peek()) {
			stack1.pop();
			stack3.pop();
			boolean bool = aux(stack1, stack2, stack3, mark, i - 1, j);
			mark[i][j] = bool ? 1 : 2;
			return bool;
		} else if (stack3.peek() == stack2.peek()
				&& (stack3.peek() != stack1.peek())) {
			stack2.pop();
			stack3.pop();
			boolean bool = aux(stack1, stack2, stack3, mark, i, j - 1);
			mark[i][j] = bool ? 1 : 2;
			return bool;
		} else if (stack3.peek() == stack1.peek()
				&& stack3.peek() == stack2.peek()) {
			stack3.pop();
			Stack<Character> stack1copy = (Stack<Character>) stack1.clone();
			Stack<Character> stack2copy = (Stack<Character>) stack2.clone();
			Stack<Character> stack3copy = (Stack<Character>) stack3.clone();
			stack1.pop();
			boolean bool1 = aux(stack1, stack2, stack3, mark, i - 1, j);
			stack2copy.pop();
			boolean bool2 = aux(stack1copy, stack2copy, stack3copy, mark, i,
					j - 1);
			boolean bool = bool1 || bool2;
			mark[i][j] = bool ? 1 : 2;
			return bool;
		} else {
			mark[i][j] = 2;
			return false;
		}
	}
}

package question.question1_99;

/*
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

//这道题的正统接发就是用Stack，同时注意对HashSet（Stack和List等也一样）赋初值的方法——我现在才知道这么写
public class Question71_others1 {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		HashSet<String> set = new HashSet<String>(Arrays.asList("..", "/", ".",
				""));
		for (String element : path.split("/")) {
			if (element.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (!set.contains(element))
				stack.add(element);
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.insert(0, "/" + stack.pop());
		return sb.length() == 0 ? "/" : sb.toString();
	}
}

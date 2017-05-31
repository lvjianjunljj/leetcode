package question.question300_399;

import java.util.Stack;

//和385一样都能用stack实现
public class Question394_others {
	public String decodeString(String s) {
		int i = 0;
		Stack<Integer> num = new Stack<Integer>();
		Stack<String> str = new Stack<String>();
		str.push("");
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				int start = i;
				while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
					i++;
				num.push(Integer.valueOf(s.substring(start, i + 1)));
			} else if (c >= 'a' && c <= 'z') {
				int start = i;
				while (i + 1 < s.length() && s.charAt(i + 1) >= 'a'
						&& s.charAt(i + 1) <= 'z')
					i++;
				str.push(str.pop() + s.substring(start, i + 1));
			} else if (c == ']') {
				String st = str.pop();
				int count = num.pop();
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < count; k++)
					sb.append(st);
				str.push(str.pop() + sb.toString());
			} else
				str.push("");
			i++;
		}
		return str.pop();
	}
}

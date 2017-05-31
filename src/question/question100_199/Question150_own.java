package question.question100_199;

import java.util.ArrayList;

//个人以为至少要遍历一遍，但是时间复杂度好高，本人不太服气啊！！！看看别人的方法
public class Question150_own {
	public int evalRPN(String[] tokens) {
		ArrayList<String> str = new ArrayList<String>();
		if (tokens.length == 0) {
			return 0;
		}
		if (tokens.length == 1) {
			return Integer.parseInt(tokens[0]);
		}
		for (String i : tokens) {
			str.add(i);
		}
		int tran = 0;
		for (int i = 2; i < str.size(); i++) {
			if (str.get(i).equals("+")) {
				tran = Integer.parseInt(str.get(i - 2))
						+ Integer.parseInt(str.get(i - 1));
				str.set(i - 2, tran + "");
				str.remove(i);
				str.remove(i - 1);
				i -= 2;
			} else if (str.get(i).equals("-")) {
				tran = Integer.parseInt(str.get(i - 2))
						- Integer.parseInt(str.get(i - 1));
				str.set(i - 2, tran + "");
				str.remove(i);
				str.remove(i - 1);
				i -= 2;
			} else if (str.get(i).equals("*")) {
				tran = Integer.parseInt(str.get(i - 2))
						* Integer.parseInt(str.get(i - 1));
				str.set(i - 2, tran + "");
				str.remove(i);
				str.remove(i - 1);
				i -= 2;
			} else if (str.get(i).equals("/")) {
				tran = Integer.parseInt(str.get(i - 2))
						/ Integer.parseInt(str.get(i - 1));
				str.set(i - 2, tran + "");
				str.remove(i);
				str.remove(i - 1);
				i -= 2;
			}
		}
		return Integer.parseInt(str.get(0));
	}
}

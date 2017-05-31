package question.question200_299;

/*
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), 
 * the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 */
//md，居然超时了。
import java.util.ArrayList;

public class Question224_own {
	public int calculate(String s) {
		s = s.replace(" ", "");
		while (s.indexOf("(") != -1) {
			int indexFront = s.lastIndexOf("(");
			int indexBack = s.indexOf(")", indexFront);
			s = s.substring(0, indexFront)
					+ aux(s.substring(indexFront + 1, indexBack))
					+ s.substring(indexBack + 1, s.length());
			s = s.replace("--", "+");
		}
		return aux(s);
	}

	public static int aux(String s) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		String[] element1 = s.split("\\+");
		for (String str1 : element1) {
			ArrayList<String> array = new ArrayList<String>();
			String[] element2 = str1.split("\\-");
			for (String str2 : element2) {
				array.add(str2);
			}
			list.add(array);
		}
		int result_final = 0;
		for (int i = 0; i < list.size(); i++) {
			int result = 0;
			if (!list.get(i).get(0).equals("")) {
				result = Integer.parseInt(list.get(i).get(0));
			}
			for (int j = 1; j < list.get(i).size(); j++) {
				result -= Integer.parseInt(list.get(i).get(j));
			}
			result_final += result;
		}
		return result_final;
	}
}

package question.question200_299;
/*
 * mplement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 */
//用split方法硬把每一个数字都费力出来
import java.util.ArrayList;

public class Question227_own {
	public static int calculate(String s) {
		s = s.replace(" ", "");
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
			int result = aux(list.get(i).get(0));
			for (int j = 1; j < list.get(i).size(); j++) {
				result -= aux(list.get(i).get(j));
			}
			result_final += result;
		}
		return result_final;
	}

	public static int aux(String s) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		String[] element1 = s.split("\\*");
		for (String str1 : element1) {
			ArrayList<String> array = new ArrayList<String>();
			String[] element2 = str1.split("/");
			for (String str2 : element2) {
				array.add(str2);
			}
			list.add(array);
		}
		int result_final = 1;
		for (int i = 0; i < list.size(); i++) {
			result_final *= Integer.parseInt(list.get(i).get(0));
			for (int j = 1; j < list.get(i).size(); j++) {
				result_final = result_final
						/ Integer.parseInt(list.get(i).get(j));
			}
		}
		return result_final;
	}
}

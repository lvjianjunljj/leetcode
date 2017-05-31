package question.question1_99;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//用HashMap存储的时候一个个往里面加确实显得比较low
public class Question17_own1 {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		map.put(2, new ArrayList<String>());
		map.put(3, new ArrayList<String>());
		map.put(4, new ArrayList<String>());
		map.put(5, new ArrayList<String>());
		map.put(6, new ArrayList<String>());
		map.put(7, new ArrayList<String>());
		map.put(8, new ArrayList<String>());
		map.put(9, new ArrayList<String>());
		map.get(2).add("a");
		map.get(2).add("b");
		map.get(2).add("c");
		map.get(3).add("d");
		map.get(3).add("e");
		map.get(3).add("f");
		map.get(4).add("g");
		map.get(4).add("h");
		map.get(4).add("i");
		map.get(5).add("j");
		map.get(5).add("k");
		map.get(5).add("l");
		map.get(6).add("m");
		map.get(6).add("n");
		map.get(6).add("o");
		map.get(7).add("p");
		map.get(7).add("q");
		map.get(7).add("r");
		map.get(7).add("s");
		map.get(8).add("t");
		map.get(8).add("u");
		map.get(8).add("v");
		map.get(9).add("w");
		map.get(9).add("x");
		map.get(9).add("y");
		map.get(9).add("z");
		char[] list = digits.toCharArray();
		dfs(res, map, new StringBuilder(), list, 0, 0);
		return res;
	}

	private void dfs(List<String> res, HashMap<Integer, List<String>> map,
			StringBuilder path, char[] list, int index, int count) {
		if (list.length == 0)
			return;
		if (count == list.length)
			res.add(path.toString());
		else {
			for (String c : map.get(list[index] - '0')) {
				path.append(c);
				dfs(res, map, path, list, index + 1, count + 1);
				path.deleteCharAt(path.length() - 1);
			}
		}
	}
}

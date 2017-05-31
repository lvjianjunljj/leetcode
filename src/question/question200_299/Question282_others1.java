package question.question200_299;

/*
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits 
 * so they evaluate to the target value.
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 */
import java.util.ArrayList;
import java.util.List;

//没想到这道题能用回溯来做，虽然耗时非常长，但是也是个办法，思路也不是很难——经典啊
public class Question282_others1 {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<String>();
		dfs(num, res, "", 0, 0, 0, target);
		return res;
	}

	private void dfs(String num, List<String> res, String path, int index,
			long bef, long mul, int target) {
		if (index == num.length()) {
			if (bef == target)
				res.add(path);
			return;
		}
		for (int i = index; i < num.length(); i++) {
			if (i != index && num.charAt(index) == '0')
				break;
			long cur = Long.parseLong(num.substring(index, i + 1));
			if (index == 0)
				dfs(num, res, num.substring(0, i + 1), i + 1, cur, cur, target);
			else {
				dfs(num, res, path + "+" + num.substring(index, i + 1), i + 1,
						bef + cur, cur, target);
				dfs(num, res, path + "-" + num.substring(index, i + 1), i + 1,
						bef - cur, -cur, target);
				dfs(num, res, path + "*" + num.substring(index, i + 1), i + 1,
						bef - mul + mul * cur, mul * cur, target);
			}
		}
	}
}

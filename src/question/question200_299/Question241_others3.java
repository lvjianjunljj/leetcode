package question.question200_299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//用HashMap<String, List<Integer>>存储来实现类似于动态规划（带备忘录的——计算出的小块结果存到map中）
//和others2的想法是一模一样的，只是写法有点区别
public class Question241_others3 {

	HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

	public List<Integer> diffWaysToCompute(String input) {
		if (map.containsKey(input))
			return map.get(input);
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (int l : left) {
					for (int r : right) {
						if (c == '+')
							res.add(l + r);
						else if (c == '-')
							res.add(l - r);
						else
							res.add(l * r);
					}
				}
			}
		}
		if (res.isEmpty())
			res.add(Integer.parseInt(input));
		map.put(input, res);
		return res;
	}
}

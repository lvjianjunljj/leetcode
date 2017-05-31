package question.question1_99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//用类似于动态规划的方法做的，虽然耗时较高倒是本身这种想法还是很有意思的
public class Question22_others {
	public List<String> generateParenthesis(int n) {
		List<List<String>> data = new ArrayList<List<String>>();
		data.add(Collections.singletonList(""));
		for (int i = 1; i <= n; i++) {
			List<String> res = new ArrayList<String>();
			for (int j = 0; j < i; j++) {
				List<String> before = data.get(j);
				List<String> after = data.get(i - 1 - j);
				for (String left : before)
					for (String right : after)
						res.add("(" + left + ")" + right);
			}
			data.add(res);
		}
		return data.get(n);
	}
}

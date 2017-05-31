package question.question1_99;

import java.util.ArrayList;
import java.util.List;
//回溯的方法也可已精简得耗时很低，还要努力
public class Question93_others1 {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		dfs(s, res, "", 0, 0);
		return res;
	}

	private void dfs(String s, List<String> res, String ip, int index, int count) {
		if (count > 4 || index > s.length())
			return;
		if (count == 4 && index == s.length())
			res.add(ip);
		for (int i = 1; i < 4; i++) {
			if (index + i > s.length())
				break;
			String part = s.substring(index, index + i);
			if ((part.charAt(0) == '0' && part.length() > 1)
					|| Integer.parseInt(part) > 255)
				continue;
			dfs(s, res, ip + part + (count == 3 ? "" : "."), index + i,
					count + 1);
		}
	}
}

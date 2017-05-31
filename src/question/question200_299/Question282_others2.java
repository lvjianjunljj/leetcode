package question.question200_299;

import java.util.LinkedList;
import java.util.List;

//将第一层循环放到外面，不太想写了，都是回溯的思路——实现起来确实也不麻烦
public class Question282_others2 {
	public List<String> addOperators(String num, int target) {
		int l = num.length();
		List<String> res = new LinkedList<String>();
		if (l == 0)
			return res;
		char[] path = new char[l * 2 - 1];
		char[] nums = num.toCharArray();
		long n = 0;
		for (int i = 0; i < l; i++) {
			n = n * 10 + nums[i] - '0';
			path[i] = nums[i];
			dfs(nums, res, path, target, i + 1, i + 1, n, n);
			if (n == 0)
				break;
		}
		return res;
	}

	private void dfs(char[] nums, List<String> res, char[] path, int target,
			int index, int len, long bef, long mul) {
		if (index == nums.length) {
			if (bef == target)
				res.add(new String(path, 0, len));
			return;
		}
		long n = 0;
		int j = len + 1;
		for (int i = index; i < nums.length; i++) {
			n = n * 10 + nums[i] - '0';
			path[j++] = nums[i];
			path[len] = '+';
			dfs(nums, res, path, target, i + 1, j, bef + n, n);
			path[len] = '-';
			dfs(nums, res, path, target, i + 1, j, bef - n, -n);
			path[len] = '*';
			dfs(nums, res, path, target, i + 1, j, bef - mul + mul * n, mul * n);
			if (n == 0)
				break;
		}
	}
}

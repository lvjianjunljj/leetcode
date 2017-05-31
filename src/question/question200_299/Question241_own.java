package question.question200_299;

/*
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * Example 1
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
import java.util.ArrayList;
import java.util.List;

//这道题是受到95_own的思路做出来的——一开始感觉好难——不要被吓到
//这两道题是首次遍历递归得到的list，感觉用的还算是得心应手——divide and conquer的题很多都是这么做，自己想通我也是挺牛逼
//哈哈哈
public class Question241_own {
	public List<Integer> diffWaysToCompute(String input) {
		String[] nums = input.split("[+*-]");
		List<Integer> op = new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		for (char c : input.toCharArray())
			if (c == '+' || c == '-' || c == '*')
				op.add(c == '+' ? 0 : (c == '-' ? 1 : 2));
		return aux(nums, op, 0, nums.length - 1);
	}

	private List<Integer> aux(String[] nums, List<Integer> op, int i, int j) {
		List<Integer> res = new ArrayList<Integer>();
		if (i == j)
			res.add(Integer.parseInt(nums[i]));
		else if (i < j)
			for (int k = i; k < j; k++)
				for (int left : aux(nums, op, i, k))
					for (int right : aux(nums, op, k + 1, j))
						res
								.add(op.get(k) == 0 ? left + right
										: (op.get(k) == 1 ? left - right : left
												* right));
		return res;
	}
}

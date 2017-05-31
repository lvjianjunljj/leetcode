package question.question1_99;

/*
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely 
 * (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */
//就是考虑的情况太多，又是各种符号又是正负号的，还有各种数组越界
//而且规则还没说清楚——一上来符号多了返回0，中间有符号返回前面的值——没意思
public class Question08_own {
	public int myAtoi(String str) {
		str = str.trim();
		int n = str.length();
		int i = 0, l = 0, res = 0;
		boolean ne = false, max = false;
		for (; i < n; i++) {
			if (str.charAt(i) == '-')
				ne = true;
			else if (str.charAt(i) != '+')
				break;
		}
		if (i > 1)
			return 0;
		for (; i < n; i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				res *= 10;
				res += str.charAt(i) - '0';
			} else
				break;
			if (res < 0 || ++l > 10) {
				max = true;
				res = Integer.MAX_VALUE;
				break;
			}
		}
		if (max && ne)
			res = Integer.MIN_VALUE;
		else
			res = ne ? -res : res;
		return res;
	}
}

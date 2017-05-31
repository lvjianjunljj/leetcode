package question.question200_299;
//遍历一遍，将之前的符号维护在另一个变量之中，确实聪明 ，比我的4层循环好很多
public class Question227_others {
	public int calculate(String s) {
		int num = 0, term = 1, res = 0;
		int sign = 1; // 1: '+', -1: '-'
		char op = '*';
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '+' || cur == '-') {
				term = (op == '*') ? term * num : term / num;
				res += sign * term;
				term = 1;
				num = 0;
				op = '*';
				sign = (cur == '+') ? 1 : -1;
			} else if (cur == '*' || cur == '/') {
				term = (op == '*') ? term * num : term / num;
				num = 0;
				op = cur;
			} else if (cur >= '0' && cur <= '9')
				num = 10 * num + cur - '0';
		}
		term = (op == '*') ? term * num : term / num;
		res += sign * term; // the last character
		return res;
	}
}

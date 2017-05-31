package question.question300_399;

/*
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, 
 * each subsequent number in the sequence must be the sum of the preceding two.
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 */

//这个题测试案例给的不完善，题本身并没有什么难的，用类似于深度优先搜索做，就是封装的方法有点多
public class Question306_own {
	public boolean isAdditiveNumber(String num) {
		if (num.length() < 3)
			return false;
		for (int i = 1; i < num.length() / 2 + 1; i++)
			for (int j = i + 1; j < num.length() * 2 / 3 + 1; j++)
				if (i + 1 == j || num.charAt(i) != '0' && num.charAt(j) != '0')
					if (aux(num, i, j))
						return true;
		return false;
	}

	private boolean aux(String num, int start, int end) {
		if (end == num.length())
			return true;
		String res = add(num.substring(0, start), num.substring(start, end));
		if (num.length() >= end + res.length()
				&& res.equals(num.substring(end, end + res.length())))
			return aux(num.substring(start), end - start, end + res.length()
					- start);
		else
			return false;
	}

	private String add(String a, String b) {
		int n = Math.max(a.length(), b.length());
		boolean aLong = a.length() > b.length();
		int differ = aLong ? a.length() - b.length() : b.length() - a.length();
		int carry = 0;
		char[] res = new char[n + 1];
		for (int i = n; i >= 0; i--) {
			int iFirst = aLong ? i - 1 : i - 1 - differ;
			int iSecond = aLong ? i - 1 - differ : i - 1;
			char first = iFirst >= 0 ? a.charAt(iFirst) : '0';
			char second = iSecond >= 0 ? b.charAt(iSecond) : '0';
			int tmp = first + second + carry - '0' * 2;
			res[i] = (char) (tmp % 10 + '0');
			carry = tmp > 9 ? 1 : 0;
		}
		String result = new String(res);
		return result.charAt(0) == '0' ? result.substring(1) : result;
	}
}

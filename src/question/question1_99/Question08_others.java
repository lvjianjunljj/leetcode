package question.question1_99;

//这才是最简洁的方法，同时耗时也降低了，没有那么多判断
public class Question08_others {
	public int myAtoi(String str) {
		int sign = 1, base = 0, i = 0;
		while (i < str.length() && str.charAt(i) == ' ')
			i++;
		if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+'))
			sign = str.charAt(i++) == '-' ? -1 : 1;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if ((base == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')
					|| base > Integer.MAX_VALUE / 10)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			base = base * 10 + str.charAt(i++) - '0';
		}
		return base * sign;
	}
}

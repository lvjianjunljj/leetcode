package question.question100_199;

/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
import java.util.ArrayList;
//用数组和String实现的话，耗时会高很多。
public class Question166_own {
	public String fractionToDecimal(int numerator, int denominator) {
		long num = (long) numerator;
		long den = (long) denominator;
		if (num % den == 0)
			return num / den + "";
		boolean negative = false;
		if ((num < 0 && den > 0) || (num > 0 && den < 0))
			negative = true;
		num = Math.abs(num);
		den = Math.abs(den);
		ArrayList<Long> array = new ArrayList<Long>();
		ArrayList<Long> rem = new ArrayList<Long>();
		rem.add(num % den);
		StringBuilder res = new StringBuilder();
		res.append(num / den + ".");
		if (negative)
			res.insert(0, "-");
		num = num % den;
		boolean mark = !(num * 10 / den > 0);
		while (rem.indexOf(num * 10 % den) == -1 && num * 10 % den > 0) {
			rem.add(num * 10 % den);
			array.add(num * 10 / den);
			num = num * 10 % den;
		}
		if (num * 10 % den == 0) {
			array.add(num * 10 / den);
			for (Long s : array)
				res.append(s);
		} else {
			array.add(num * 10 / den);
			int n = rem.indexOf(num * 10 % den) + res.length();
			for (Long s : array)
				res.append(s);
			res.insert(n, "(");
			res.append(")");
		}
		return res.toString();
	}
}

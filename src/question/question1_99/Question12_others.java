package question.question1_99;

/*
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

//知道了规则的话其实这道题并不难，但这种想法和写法还是非常厉害的
public class Question12_others {
	public String intToRoman(int num) {
		String[] th = { "", "M", "MM", "MMM" };
		String[] hu = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC",
				"CM" };
		String[] te = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX",
				"XC" };
		String[] on = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
				"IX" };
		return th[num / 1000] + hu[(num % 1000) / 100] + te[(num % 100) / 10]
				+ on[num % 10];
	}
}

package question.question200_299;
/*
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
//蛮有意思的
public class Question273 {
	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		String result = "";
		if (num > 999999999) {
			int a = num / 1000000000;
			result += tranThree(a) + " Billion";
			num -= a * 1000000000;
		}
		if (num > 999999) {
			int a = num / 1000000;
			result += tranThree(a) + " Million";
			num -= a * 1000000;
		}
		if (num > 999) {
			int a = num / 1000;
			result += tranThree(a) + " Thousand";
			num -= a * 1000;
		}
		if (num > 0) {
			result += tranThree(num);
		}
		result = result.trim();
		return result;

	}

	// num在1到999之间
	// num在1到999之间
	protected static String tranThree(int num) {
		String result = "";
		if (num == 0) {
			return "";
		}
		if (num > 99) {
			result = "Hundred";
			int a = num / 100;
			switch (a) {
			case 1:
				result = " One " + result;
				break;
			case 2:
				result = " Two " + result;
				break;
			case 3:
				result = " Three " + result;
				break;
			case 4:
				result = " Four " + result;
				break;
			case 5:
				result = " Five " + result;
				break;
			case 6:
				result = " Six " + result;
				break;
			case 7:
				result = " Seven " + result;
				break;
			case 8:
				result = " Eight " + result;
				break;
			case 9:
				result = " Nine " + result;
				break;
			default:
				break;
			}
			//这样写耗时更少，比取余更快
			num -= a * 100;
		}
		if (num > 9) {
			int a = num / 10;
			switch (a) {
			case 1:
				result += tranTwo(num);
				return result;
			case 2:
				result += " Twenty";
				break;
			case 3:
				result += " Thirty";
				break;
			case 4:
				result += " Forty";
				break;
			case 5:
				result += " Fifty";
				break;
			case 6:
				result += " Sixty";
				break;
			case 7:
				result += " Seventy";
				break;
			case 8:
				result += " Eighty";
				break;
			case 9:
				result += " Ninety";
				break;
			default:
				break;
			}
			num -= a * 10;
		}
		if (num > 0) {
			switch (num) {
			case 1:
				result += " One";
				break;
			case 2:
				result += " Two";
				break;
			case 3:
				result += " Three";
				break;
			case 4:
				result += " Four";
				break;
			case 5:
				result += " Five";
				break;
			case 6:
				result += " Six";
				break;
			case 7:
				result += " Seven";
				break;
			case 8:
				result += " Eight";
				break;
			case 9:
				result += " Nine";
				break;
			default:
				break;
			}
		}
		return result;
	}

	// num在10到19之间
	protected static String tranTwo(int num) {
		String result = "";
		int a = num - num / 10 * 10;
		switch (a) {
		case 0:
			result = " Ten";
			break;
		case 1:
			result = " Eleven";
			break;
		case 2:
			result = " Twelve";
			break;
		case 3:
			result = " Thirteen";
			break;
		case 4:
			result = " Fourteen";
			break;
		case 5:
			result = " Fifteen";
			break;
		case 6:
			result = " Sixteen";
			break;
		case 7:
			result = " Seventeen";
			break;
		case 8:
			result = " Eighteen";
			break;
		case 9:
			result = " Nineteen";
			break;
		default:
			break;
		}
		return result;
	}
}

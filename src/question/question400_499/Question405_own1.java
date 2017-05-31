package question.question400_499;
/*
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, 
 * two’s complement method is used.
 * Note:
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, 
 * it is represented by a single zero character '0'; otherwise, 
 * the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * Input:
 * 26
 * Output:
 * "1a"
 * Example 2:
 * Input:
 * -1
 * Output:
 * "ffffffff"
 */

//先将其转换成二进制再转换成16进制，突然想到完全可以直接转换成16进制，参照own2
public class Question405_own1 {
	public String toHex(int num) {
		if (num == 0)
			return "0";
		String str = "", res = "";
		while (num != 0) {
			str = (num & 1) + str;
			num = num >>> 1;
		}
		char[] list = new char[16];
		for (int i = 0; i < 10; i++)
			list[i] = (char) ('0' + i);
		for (int i = 10; i < 16; i++)
			list[i] = (char) ('a' + i - 10);
		for (int i = 0; i <= (str.length() - 1) / 4; i++) {
			int th = (str.charAt(str.length() - 1 - i * 4) - '0')
					+ (str.length() - 1 - i * 4 > 0 ? (str.charAt(str.length()
							- 2 - i * 4) - '0') * 2 : 0)
					+ (str.length() - 2 - i * 4 > 0 ? (str.charAt(str.length()
							- 3 - i * 4) - '0') * 4 : 0)
					+ (str.length() - 3 - i * 4 > 0 ? (str.charAt(str.length()
							- 4 - i * 4) - '0') * 8 : 0);
			res = list[th] + res;
		}
		return res;
	}
}

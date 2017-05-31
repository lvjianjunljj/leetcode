package question.question1_99;

/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 */
//自己封装的乘和加的方法，简直是麻烦
public class Question43_own {
	public String multiply(String num1, String num2) {
		char[] array1 = num1.toCharArray();
		char[] array2 = num2.toCharArray();
		int m = array1.length, n = array2.length;
		char[] array = new char[m + n + 1];
		for (int j = 0; j < array.length; j++)
			array[j] = '0';
		for (int i = m - 1; i >= 0; i--) {
			char[] multi = multi(array2, array1[i]);
			char[] mul = new char[multi.length + m - i - 1];
			for (int j = 0; j < multi.length; j++)
				mul[j] = multi[j];
			for (int j = multi.length; j < multi.length + m - i - 1; j++)
				mul[j] = '0';
			array = add(mul, array);
		}
//		String res = "";
//		for (char k : array)
//			res += k;
//		while (res.charAt(0) == '0' && res.length() > 1)
//			res = res.substring(1);
//		return res;
		//当经常对字符串进行拼接时，用StringBuilder远比String的耗时低。
		StringBuilder res = new StringBuilder();
		for (char k : array)
			if (!(res.length() == 0 && k == '0'))
			    res.append(k - '0');
		return res.length() == 0 ? "0" : res.toString();
	}

	protected static char[] multi(char[] array, char s) {
		int n = array.length;
		char[] res = new char[n + 1];
		int carry = 0;
		for (int i = n - 1; i >= 0; i--) {
			int pro = (array[i] - '0') * (s - '0') + carry;
			res[i + 1] = (char) (pro % 10 + '0');
			carry = pro / 10;
		}
		res[0] = (char) (carry + '0');
		return res;
	}

	protected static char[] add(char[] array1, char[] array2) {
		int n = array2.length;
		int dif = array2.length - array1.length;
		int carry = 0;
		char[] res = new char[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			int value = i >= dif ? array1[i - dif] - '0' : 0;
			int add = value + array2[i] - '0' + carry;
			res[i + 1] = (char) (add % 10 + '0');
			carry = add / 10;
		}
		res[0] = (char) (carry + '0');
		return res;
	}
}

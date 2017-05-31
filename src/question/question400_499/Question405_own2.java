package question.question400_499;

//优化了一下代码，直接对num右移的时候就每四位算作一个字符填到结果中，没必要先转成二进制
public class Question405_own2 {
	public String toHex(int num) {
		if (num == 0)
			return "0";
		String res = "";
		int base = 1, th = 0;
		char[] list = new char[16];
		for (int i = 0; i < 10; i++)
			list[i] = (char) (i + '0');
		for (int i = 10; i < 16; i++)
			list[i] = (char) (i + 'a' - 10);
		while (num != 0) {
			if (base == 16) {
				res = list[th] + res;
				base = 1;
				th = 0;
			}
			th += (num & 1) * base;
			num = num >>> 1;
			base *= 2;
		}
		if (th != 0)
			res = list[th] + res;
		return res;
	}
}
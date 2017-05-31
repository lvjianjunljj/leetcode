package question.question200_299;
//转成char做——4ms
public class Question258_own2 {
	public int addDigits(int num) {
		while (num > 9)
			num = aux(num);
		return num;
	}

	public static int aux(int num) {
		char[] list = (num + "").toCharArray();
		int res = 0;
		for (char i : list)
			res += i - '0';
		return res;
	}
}

package question.question200_299;
//用取余做——4ms
public class Question258_own3 {
	public int addDigits(int num) {
		while (num > 9)
			num = aux(num);
		return num;
	}

	public static int aux(int num) {
		char[] list = (num + "").toCharArray();
		int res = 0;
		while (num > 0) {
			res += num % 10;
			num = num / 10;
		}
		return res;
	}
}

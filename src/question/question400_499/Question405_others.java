package question.question400_499;

//根本没必要一位一位的移，四位四位的移才是正道，我还是太菜啊
public class Question405_others {
	public String toHex(int num) {
		String[] list = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"a", "b", "c", "d", "e", "f" };
		String res = "";
		do {
			res = list[num & 15] + res;
			num = num >>> 4;
		} while (num != 0);
		return res;
	}
}

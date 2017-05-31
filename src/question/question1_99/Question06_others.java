package question.question1_99;

//用这种写法才是最简单的
public class Question06_others {
	public String convert(String s, int numRows) {
		char[] list = s.toCharArray();
		int i = 0;
		StringBuilder[] sbs = new StringBuilder[numRows];
		for (int j = 0; j < numRows; j++) {
			sbs[j] = new StringBuilder();
		}
		while (i < list.length) {
			for (int j = 0; j < numRows && i < list.length; j++) {
				sbs[j].append(list[i++]);
			}
			for (int j = numRows - 2; j > 0 && i < list.length; j--) {
				sbs[j].append(list[i++]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < sbs.length; j++) {
			sb.append(sbs[j]);
		}
		return sb.toString();
	}
}

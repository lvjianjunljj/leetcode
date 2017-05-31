package question.question1_99;

//这道题还是用递归做最快
public class Question_own2 {
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String prev = countAndSay(n - 1);
		StringBuilder sb = new StringBuilder();
		int count = 1;
		char num = prev.charAt(0);
		for (int i = 1; i < prev.length(); i++) {
			if (prev.charAt(i) == num) {
				count++;
			} else {
				sb.append(count).append(num);
				count = 1;
				num = prev.charAt(i);
			}
		}
		sb.append(count).append(num);
		return sb.toString();
	}
}

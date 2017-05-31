package question.question1_99;
//参考了别人的代码简化了步骤，自己的方法简直是麻烦
public class Question43_others {
	public String multiply(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();
		int[] res = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int p1 = i + j;
				int p2 = p1 + 1;
				int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0')
						+ res[p2];
				res[p1] += sum / 10;
				res[p2] = sum % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : res)
			if (!(sb.length() == 0 && i == 0))
				sb.append(i);
		return sb.length() == 0 ? "0" : sb.toString();
	}
}

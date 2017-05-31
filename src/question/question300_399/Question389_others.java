package question.question300_399;

//参考答案以后能写出的最简洁的代码了——直接就对char进行异或运算就行啊
public class Question389_others {
	public char findTheDifference(String s, String t) {
		char c = t.charAt(t.length() - 1);
		for (int i = 0; i < t.length() - 1; i++)
			c ^= (s.charAt(i) ^ t.charAt(i));
		return c;
	}
}

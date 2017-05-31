package question.question300_399;
//StringBuilder早就封装了对应的方法
public class Question344_others1 {
	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}

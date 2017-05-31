package question.question100_199;
//完全就是用了正则表达式，多涉猎一些也是好的
public class Question125_others1 {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
		return new StringBuilder(s).reverse().toString().equals(s);
	}
}

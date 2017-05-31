package question.question300_399;
//果然是有想法啊，向大了去而不是向小了走。
public class Question326_others {
	public boolean isPowerOfThree(int n) {
		// 1162261467 is 3^19,  3^20 is bigger than int 
		return (n > 0 && 1162261467 % n == 0);
	}
}

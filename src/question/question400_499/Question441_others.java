package question.question400_499;

//数学思维才是王道，卧槽，这个8简直是巧妙
public class Question441_others {
	public int arrangeCoins(int n) {
		return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
	}
}

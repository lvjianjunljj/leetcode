package question.question200_299;
//其实维护一个数组就够了，用正负代替secret和guess两个String的每一位是否出现过
public class Question299_others2 {
	public String getHint(String secret, String guess) {
		int bulls = 0, cows = 0;
		int[] list = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int se = Character.getNumericValue(secret.charAt(i));
			int gu = Character.getNumericValue(guess.charAt(i));
			if (se == gu)
				bulls++;
			else {
				if (list[se] < 0)
					cows++;
				if (list[gu] > 0)
					cows++;
				list[se]++;
				list[gu]--;
			}
		}
		return bulls + "A" + cows + "B";
	}
}

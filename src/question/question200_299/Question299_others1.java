package question.question200_299;
//用Question205_others1相应的方法，将secret和guess每一位的都存储在一个10位数组中——美妙。。。
public class Question299_others1 {
	public String getHint(String secret, String guess) {
		int bulls = 0, cows = 0;
		int[] se = new int[10];
		int[] gu = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i))
				bulls++;
			else {
				se[secret.charAt(i) - '0']++;
				gu[guess.charAt(i) - '0']++;
				if (gu[secret.charAt(i) - '0'] > 0)
					cows++;
				if (se[guess.charAt(i) - '0'] > 0)
					cows++;
				gu[secret.charAt(i) - '0']--;
				se[guess.charAt(i) - '0']--;
			}
		}
		return bulls + "A" + cows + "B";
	}
}

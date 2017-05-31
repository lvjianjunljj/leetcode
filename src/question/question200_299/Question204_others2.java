package question.question200_299;

public class Question204_others2 {
	public int countPrimes(int n) {
		int count = 0;
		boolean[] judge = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (!judge[i])
				count++;
			for (int j = 2; j * i < n; j++)
				judge[j * i] = true;
		}
		return count;
	}
}

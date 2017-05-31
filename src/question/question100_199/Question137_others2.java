package question.question100_199;

//网上给的所谓的k重复通法，没什么意思
public class Question137_others2 {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j : nums) {
				if (((j >>> i) & 1) == 1) {
					sum++;
					sum %= 3;
				}
			}
			if (sum != 0)
				res |= (sum << i);
		}
		return res;
	}
}

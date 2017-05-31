package question.question200_299;
//这道题用迭代果然快一点，省去了判断
public class Question278_others {
	public int firstBadVersion(int n) {
		int start = 1, end = n;
		while (start < end) {
			if (isBadVersion(start + (end - start) / 2))
				end = start + (end - start) / 2;
			else
				start = start + (end - start) / 2 + 1;
		}
		return start;
	}
	
	private boolean isBadVersion(int n) {
		return n > 15;
	}
}

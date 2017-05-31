package question.question400_499;

//对own1的方法进行精简，其实这个方法的好事还是很低的
public class Question423_own2 {
	public String originalDigits(String s) {
		String[] nums = new String[] { "zero", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine" };
		char[] marks = new char[] { 'z', 'o', 'w', 'h', 'u', 'f', 'x', 's',
				'g', 'i' };
		int[] count = new int[26];
		int[] order = new int[] { 0, 2, 8, 6, 4, 3, 5, 7, 9, 1 };
		int[] res = new int[10];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < order.length; i++) {
			res[order[i]] = count[marks[order[i]] - 'a'];
			for (int j = 0; j < nums[order[i]].length(); j++) {
				count[nums[order[i]].charAt(j) - 'a'] -= res[order[i]];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i]; j++) {
				sb.append(i);
			}
		}
		return sb.toString();
	}
}

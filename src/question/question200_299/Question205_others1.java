package question.question200_299;

//这个方法简直是美妙。数组中存储每个字符出现的最后一次的坐标（两者视为对应字符），不同则返回false。
//ASCII码中英文字符char一共有256个
public class Question205_others1 {
	public boolean isIsomorphic(String s, String t) {
		int[] mark1 = new int[256];
		int[] mark2 = new int[256];
		for (int i = 0; i < s.length(); i++) {
			if (mark1[s.charAt(i)] != mark2[t.charAt(i)])
				return false;
			mark1[s.charAt(i)] = i + 1;
			mark2[t.charAt(i)] = i + 1;
		}
		return true;
	}
}

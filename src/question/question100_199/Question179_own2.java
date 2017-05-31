package question.question100_199;

import java.util.Arrays;
import java.util.Comparator;
//这是我封装的另一个方法，用String的compareTo方法去做，个人感觉没什么问题，但是报TimeError的错误，先放一放吧
public class Question179_own2 {
	public String largestNumber(int[] nums) {
		Comparator<Integer> c = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String str1 = o1 + "";
				String str2 = o2 + "";
				if (str1.compareTo(str2) == 0)
					return 0;
				if (str1.length() == str2.length())
					return str1.compareTo(str2) > 0 ? -1 : 1;
				else {
					while (str1.length() > 1 || str2.length() > 1) {
						if (str1.length() == str2.length())
							return str1.compareTo(str2) > 0 ? -1 : 1;
						else if (str1.length() < str2.length()) {
							if (str1.compareTo(str2) > 0)
								return -1;
							else if (str1.compareTo(str2.substring(0, str1
									.length())) != 0)
								return str1.compareTo(str2.substring(0, str1
										.length()));
							else
								str2 = str2.substring(str1.length());
						} else {
							if (str1.compareTo(str2) < 0)
								return 1;
							else if (str2.compareTo(str1.substring(0, str2
									.length())) != 0)
								return str2.compareTo(str1.substring(0, str2
										.length()));
							else
								str1 = str1.substring(str2.length());
						}
					}
					if (str1.compareTo(str2) == 0)
						return 0;
					return str1.compareTo(str2) > 0 ? -1 : 1;
				}
			}
		};
		Integer[] num = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++)
			num[i] = nums[i];
		Arrays.sort(num, c);
		if (num[0] == 0)
			return "0";
		String res = "";
		for (int i : num)
			res += i;
		return res;
	}
}

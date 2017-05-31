package question.question100_199;
/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
import java.util.Arrays;
import java.util.Comparator;
//自己写的比较器，比较麻烦，使用String封装的compareTo方法会好很多（个人感觉）
public class Question179_own {
	public String largestNumber(int[] nums) {
		Comparator<Integer> c = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2)
					return 0;
				char[] val1 = (o1 + "").toCharArray();
				char[] val2 = (o2 + "").toCharArray();
				int m = val1.length;
				int n = val2.length;
				if (m == n) {
					for (int i = 0; i < n; i++) {
						if (val1[i] > val2[i])
							return -1;
						else if (val1[i] < val2[i])
							return 1;
					}
				} else if (m > n) {
					for (int i = 0; i < n; i++) {
						if (val1[i] > val2[i])
							return -1;
						else if (val1[i] < val2[i])
							return 1;
					}
					for (int i = n; i < m; i++) {
						if (val1[i] > val2[i % n])
							return -1;
						else if (val1[i] < val2[i % n])
							return 1;
					}
					if (m % n == 0)
						return 0;
					return val1[m - 1] > val2[m % n] ? -1 : 1;
				} else {
					for (int i = 0; i < m; i++) {
						if (val1[i] > val2[i])
							return -1;
						else if (val1[i] < val2[i])
							return 1;
					}
					for (int i = m; i < n; i++) {
						if (val1[i % m] > val2[i])
							return -1;
						else if (val1[i % m] < val2[i])
							return 1;
					}
					if (n % m == 0)
						return 0;
					return val1[n % m] > val2[n - 1] ? -1 : 1;
				}
				return 0;
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

package question.question1_99;

import java.util.ArrayList;
import java.util.List;

//用数学方法做才是这道题能做出来的方法，要想明白第二个循环的思路（要想到从一个数组中将数字剔除出来），还有要想到k--这一步。
public class Question60_others1 {
	public String getPermutation(int n, int k) {
		StringBuilder res = new StringBuilder();
		int[] count = new int[n];
		count[0] = 1;
		for (int i = 1; i < n; i++)
			count[i] = count[i - 1] * (i + 1);
		List<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			array.add(i + 1);
		k--;
		for (int i = 1; i < n; i++) {
			int index = k / count[n - 1 - i];
			res.append(array.remove(index));
			k -= index * count[n - 1 - i];
		}
		res.append(array.get(0));
		return res.toString();
	}
}

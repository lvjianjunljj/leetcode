package algorithm;

import java.util.ArrayList;
import java.util.List;

public class TrieSort {
	public static void main(String[] args) {
		long n = 200;
		long cur = 1;
		List<Long> list = new ArrayList<Long>();
		for (long i = 0; i < n; ++i) {
			list.add(cur);
			if (cur * 10 <= n) {
				cur *= 10;
			} else {
				if (cur == n)
					cur /= 10;
				cur++;
				while (cur % 10 == 0)
					cur /= 10;
			}
		}
		for (long i : list)
			System.out.println(i);
	}
}

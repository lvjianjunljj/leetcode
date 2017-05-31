package question.question300_399;

import java.util.ArrayList;
import java.util.List;

//牺牲空间复杂度以换取耗时降低——根本的思路就是这个连乘取余会形成一个环，找到这个环就能找到最后的数。
//感觉并不是很难想
public class Question372_others {
	int DIV = 1337;

	List<Integer> findLoop(int a) {
		List<Integer> index = new ArrayList<Integer>();
		boolean[] set = new boolean[DIV];
		int rem = a % DIV;
		while (!set[rem]) {
			set[rem] = true;
			index.add(rem);
			rem = (rem * a) % DIV;
		}
		return index;
	}

	private int modBy(int[] b, int m) {
		int rem = 0;
		for (int i = 0; i < b.length; i++) {
			rem = (rem * 10 + b[i]) % m;
		}
		return rem;
	}

	private int superPow(int a, int[] b) {
		if (a == 0 || a == DIV || b == null || b.length == 0)
			return 0;
		if (a == 1)
			return 1;
		if (a > DIV)
			return superPow(a % DIV, b);
		List<Integer> index = findLoop(a);
		int loopsize = index.size();
		int rem = modBy(b, loopsize);
		rem = rem == 0 ? loopsize : rem;
		return index.get(rem - 1);
	}
}

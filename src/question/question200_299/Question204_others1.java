package question.question200_299;
/*
 * Count the number of prime numbers less than a non-negative number, n.
 */
//others1和others2的想法差不多，这里通过一些步骤节省了循环的次数（完全不管偶数），降低了耗时
public class Question204_others1 {
	public int countPrimes(int n) {
        if (n < 3)
            return 0;
        int res = 1;
        boolean[] judge = new boolean[n];
        for (int i = 3; i * i < n; i++) {
            if (judge[i])
                continue;
            for (int j = i * i; j < n; j += i * 2)
                judge[j] = true;
        }
        for (int i = 3; i < n; i += 2)
            if (!judge[i])
                res++;
        return res;
    }
}

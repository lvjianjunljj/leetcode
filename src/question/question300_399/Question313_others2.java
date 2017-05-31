package question.question300_399;

import java.util.PriorityQueue;
//others思路和others1是一样的，只不过是用优先队列来实现的，耗时反而更高了
public class Question313_others2 {
	public int nthSuperUglyNumberHeap(int n, int[] primes) {
	    int[] ugly = new int[n];

	    PriorityQueue<Num> pq = new PriorityQueue<Num>();
	    for (int i = 0; i < primes.length; i++) pq.add(new Num(primes[i], 1, primes[i]));
	    ugly[0] = 1;

	    for (int i = 1; i < n; i++) {
	        ugly[i] = pq.peek().val;
	        while (pq.peek().val == ugly[i]) {
	            Num nxt = pq.poll();
	            pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
	        }
	    }
	    return ugly[n - 1];
	}

	private class Num implements Comparable<Num> {
	    int val;
	    int idx;
	    int p;

	    public Num(int val, int idx, int p) {
	        this.val = val;
	        this.idx = idx;
	        this.p = p;
	    }

	    @Override
	    public int compareTo(Num that) {
	        return this.val - that.val;
	    }
	}
}

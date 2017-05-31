package question.question300_399;

/*
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * Example1:
 * a = 2
 * b = [3]
 * Result: 8
 * Example2:
 * a = 2
 * b = [1,0]
 * Result: 1024
 */
public class Question372_own {
	// 这数组太长了，根本就不能转换成数——所以我的想法是对指数数组中的每一位进行运算，就是先求一下原数的10次幂
	// 运用了Question50的方法求次幂（稍做了修改——多了求余）——Math的pow方法的返回值是double，不利于计算且无法求余
	public int superPow(int a, int[] b) {
		int base = a % 1337;
		int res = 1;
		for (int i = 0; i < b.length; i++) {
			res = aux(res, 10);
			res = res * aux(base, b[i]) % 1337;
		}
		return res;
	}

	private int aux(int base, int index) {
		if (index == 0)
			return 1;
		return (index % 2 == 0 ? aux(base * base % 1337, index / 2) : base
				* aux(base, index - 1)) % 1337;
	}
}

package algorithm;

/**
 * 01背包问题<br>
 * V[i][j]= <br>
 * (1)max{V[i-1,j],vi+V[i-1,j-wi]} (j-wi >=0) <br>
 * (2)V[i-1,j] (j-w1 < 0)
 * 
 * <br>
 * <br>
 * 初始条件 ： j>=0,V[0][j] = 0; i >=0,V[i][0] = 0
 * 
 * <br>
 * O(nW)
 * 
 * 思路其实非常简单，就是带备忘录的自顶向下动态规划
 */
public class Knapsack {

	public static void main(String[] args) {
		// 物体价值和重量
		int[] value = new int[] { 12, 10, 20, 15 };
		int[] weight = new int[] { 2, 1, 3, 3 };
		// 背包重量
		int W = 5;

		System.out.println(knapsack(weight, value, W));

	}

	/**
	 * 
	 * @param i
	 *            第i个物件
	 * @param j
	 *            包在第i物件中加入的物件之后剩下的能加入重量
	 * @return
	 */

	public static int knapsack(int[] weight, int[] value, int W) {
		int[][] V = new int[value.length + 1][W + 1];
		for (int m = 1; m < V.length; m++)
			for (int n = 1; n < W + 1; n++) {
				V[m][n] = -1;
			}
		return aux(weight, value, V,
				value.length, W, W);
	}

	public static int aux(int[] weight, int[] value, int[][] V, int i, int j,
			int W) {
		// 初始条件 ： j>=0,V[0][j] = 0; i >=0,V[i][0] = 0 其余格为-1
		if (V[i][j] < 0) {
			if (j < weight[i - 1]) {
				V[i][j] = aux(weight, value, V, i - 1, j, W);
			} else {
				V[i][j] = Math.max(aux(weight, value, V, i - 1, j, W),
						value[i - 1]
								+ aux(weight, value, V, i - 1, j
										- weight[i - 1], W));
			}
		}
		return V[i][j];
	}
}

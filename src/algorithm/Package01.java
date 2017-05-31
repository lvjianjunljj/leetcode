package algorithm;

import java.util.Scanner;

/**
 * @author lvjj
 * @date 2017年4月8日
 * 
 */
public class Package01 {
	class Item {
		public int weight;
		public int value;
	}

	private static int weight, item_num;
	private static Item[] item;

	public Package01() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param n
	 *            前n个物品
	 * @param c
	 *            背包容量c
	 */
	public static int Iterative(int n, int C, int[][] matrix) {
		if (n == 0 || C == 0)
			return 0;
		else {
			if (matrix[n - 1][C - 1] > 0) {
				return matrix[n - 1][C - 1];
			}
			for (int i = n - 1; i >= 0; i--) {
				if (item[i].weight > C) {
					matrix[n - 1][C - 1] = Iterative(n - 1, C, matrix);
				} else {
					int temp1 = Iterative(n - 1, C, matrix);
					int temp2 = Iterative(n - 1, C - item[i].weight, matrix) + item[i].value;
					matrix[n - 1][C - 1] = Math.max(temp1, temp2);
				}
			}
		}
		return matrix[n - 1][C - 1];
	}

	public static int getValue() {
		int value = 0;

		return value;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			weight = s.nextInt();
			item_num = s.nextInt();
			item = new Item[item_num];
			for (int i = 0; i < item_num; i++) {
				item[i] = new Package01().new Item();
				item[i].weight = s.nextInt();
				item[i].value = s.nextInt();
			}

			System.out.println(Iterative(item_num, weight, new int[item_num][weight]));
		}
	}
}

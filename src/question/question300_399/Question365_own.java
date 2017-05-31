package question.question300_399;

/*
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * Operations allowed:
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 * Input: x = 2, y = 6, z = 5
 * Output: False
 */
//数学问题，能不能凑成该体积的水主要看这两个容器的容积的最大公约数是否是目标值的约数，是则可以，反之不可以——证明略
public class Question365_own {
	public boolean canMeasureWater(int x, int y, int z) {
		if (x == 0 || y == 0)
			return z == x || z == y;
		int common = getCommon(x, y);
		return z <= (x + y) && z % common == 0;
	}

	private int getCommon(int x, int y) {
		while (x != y) {
			if (x > y)
				x = x % y > 0 ? x % y : y;
			else
				y = y % x > 0 ? y % x : x;
		}
		return x;
	}
}

package question.question400_499;

/*
 * A frog is crossing a river. The river is divided into x units and at each unit there may or 
 * may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to 
 * cross the river by landing on the last stone. Initially, the frog is on the first stone and 
 * assume the first jump must be 1 unit.
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. 
 * Note that the frog can only jump in the forward direction.
 * Note:
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:
 * [0,1,3,5,6,8,12,17]
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * Return true. The frog can jump to the last stone by jumping 
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
 * 2 units to the 4th stone, then 3 units to the 6th stone, 
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 * [0,1,2,3,4,8,9,11]
 * Return false. There is no way to jump to the last stone as 
 * the gap between the 5th and 6th stone is too large.
 */
import java.util.ArrayList;
import java.util.List;

//用动态规划做是肯定可以的，但是我的Dp麻烦了一点，我记录了到达每个点之前最后一步所有可能的步数（存到一个数组中）
//所以在求这个点的时候需要遍历他前面所有的点——耗时确实高了一点
public class Question403_own {
	public boolean canCross(int[] stones) {
		if (stones.length < 2)
			return true;
		if (stones[1] != 1)
			return false;
		List<Integer>[] steps = new ArrayList[stones.length - 1];
		steps[0] = new ArrayList<Integer>();
		steps[0].add(1);
		for (int i = 1; i < steps.length; i++) {
			steps[i] = new ArrayList<Integer>();
			for (int j = 0; j < i; j++) {
				int dis = stones[i + 1] - stones[j + 1];
				for (int k : steps[j]) {
					if (dis == k || dis == k - 1 || dis == k + 1) {
						steps[i].add(dis);
						break;
					}
				}
			}
		}
		return steps[steps.length - 1].size() > 0;
	}
}

package question.question100_199;

//这种只遍历一遍操作一个sum的想法才是正确的，start不应随着判断向后走，而是向前走，同时设定一个end这样就能实现这种思路
public class Question134_others {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = gas.length - 1, end = 0, sum = gas[start] - cost[start];
		while (end < start) {
			if (sum >= 0) {
				sum += gas[end] - cost[end];
				end++;
			} else {
				start--;
				sum += gas[start] - cost[start];
			}
		}
		return sum < 0 ? -1 : start;
	}
}

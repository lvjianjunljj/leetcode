package question.question100_199;

//简洁一下自己的代码
public class Question134_own2 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++)
			gas[i] -= cost[i];
		int sum = 0, res = 0, have = 0;
		for (int i = 0; i < gas.length; i++) {
			if (sum < 0) {
				res = i;
				sum = 0;
			}
			sum += gas[i];
			have += gas[i];
		}
		return have < 0 ? -1 : res;
	}
}

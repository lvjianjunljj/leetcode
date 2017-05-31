package question.question100_199;

/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */

//这道题用贪心算法做一下就出来了，就是不知道能不能省去一开始的求和判断
public class Question134_own1 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++)
			gas[i] -= cost[i];
		int sum = 0;
		for (int i : gas)
			sum += i;
		if (sum < 0)
			return -1;
		int res = 0;
		sum = 0;
		for (int i = 0; i < gas.length; i++) {
			if (sum < 0) {
				res = i;
				sum = 0;
			}
			sum += gas[i];
		}
		return res;
	}
}

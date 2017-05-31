package question.question1_99;
//答案给的用single loop做，简洁且耗时较低，其实想法和我是类似的，e表示的就是end——当前能到达的最远点，而且省掉了判断长度为1的情况
public class Question45_others1 {
	public int jump(int[] nums) {
		int sc = 0;
		int e = 0;
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, i + nums[i]);
			if (i == e) {
				sc++;
				e = max;
			}
		}
		return sc;
	}
}

package question.question300_399;

//完全没有必要将判断方法封装成一个函数，直接可以将每一个word对应的位运算的值封装在一个数组中
//每次直接调用对应的数进行比对，减少对于每一个word对应的位运算的值的重复计算——这就是耗时最低的思路了
public class Question318_others {
	public int maxProduct(String[] words) {
		int res = 0;
		int len = words.length;
		int[] values = new int[len];
		for (int i = 0; i < len; i++) {
			values[i] = 0;
			for (int j = 0; j < words[i].length(); j++)
				values[i] |= (1 << words[i].charAt(j) - 'a');
		}
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++)
				if ((values[i] & values[j]) == 0)
					res = Math.max(res, words[i].length() * words[j].length());
		return res;
	}
}

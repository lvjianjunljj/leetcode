package question.question100_199;

//我就觉得这道题完全可以用On时间复杂度和O1空间复杂度来做，还是要有点想法才行的
public class Question135_others {
	public int candy(int[] ratings) {
		int i = 0, count = 1, lastNum = 1, n = ratings.length;
		if (n == 0)
			return 0;
		while (i < n - 1) {
			int j = i + 1;
			if (ratings[j] > ratings[i]) {
				while (j < n && ratings[j] > ratings[j - 1])
					j++;
				//每次舍弃第一位，因为该位对应的糖果树已经在上一下中加到了count中
				int tmp = j - 1 - i;
				count += tmp * (tmp + 3) / 2;
				lastNum = tmp + 1;
				//但是你在下一次运算的时候起始点还是要设置在第一位j - 1而不是j的
				i = j - 1;
			} else if (ratings[j] < ratings[i]) {
				while (j < n && ratings[j] < ratings[j - 1])
					j++;
				int tmp = j - 1 - i;
				count += tmp * (tmp + 1) / 2;
				if (tmp + 1 > lastNum)
					count += tmp + 1 - lastNum;
				lastNum = 1;
				i = j - 1;
			} else {
				count++;
				i++;
				lastNum = 1;
			}
		}
		return count;
	}
}

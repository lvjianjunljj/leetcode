package question.question200_299;

/*
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, 
 * the latest version of your product fails the quality check. Since each version is developed based on the 
 * previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
 * which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
//用二分法做已经是我想到的最快的方法了，但是耗时还是很长。
//可能和用递归有关系，这道题用递归不如用迭代快
public class Question278_own {
	int min = 1;
	int max = Integer.MAX_VALUE;

	public int firstBadVersion(int n) {
		if (isBadVersion(n) && !isBadVersion(n - 1))
			return n;
		else if (isBadVersion(n))
			max = n - 1;
		else
			min = n + 1;
		//用这种写法可以避免int数据类型的数过大造成的错误了（对于耗时完全没有影响）
		return firstBadVersion(min + (max - min) / 2);
	}

	private boolean isBadVersion(int n) {
		return n > 15;
	}
}

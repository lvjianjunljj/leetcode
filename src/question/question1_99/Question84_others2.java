package question.question1_99;

import java.util.Stack;
//用栈来实现，思路有些难想，最后栈中弹出的是该高度之前的比起高的最低的点的坐标
//虽然耗时较长但却是最通用的方法
//int h = (i == len ? 0 : height[i]);一句相当于设定了第n+1个点的高度为0，所以其实是碰到有下降点
//（与栈的第一个值进行比较是下降）的时候才会进行计算和判断。所以栈里面的序列对应的数组索引值是递增的
public class Question84_others2 {
	public int largestRectangleArea(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : height[i]);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				maxArea = Math.max(maxArea, height[tp]
						* (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
	}
}

package question.question1_99;
/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
//这个想法简直是巧妙，根本就没觉得会这么简单
public class Question11_others {
	public int maxArea(int[] height) {
		int start = 0, end = height.length - 1;
		int area = Math.min(height[start], height[end]) * (end - start);
		while (start < end) {
			area = Math.max(area, Math.min(height[start], height[end])
					* (end - start));
			if (height[start] < height[end])
				start++;
			else
				end--;
		}
		return area;
	}
}

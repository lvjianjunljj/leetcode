package question.question1_99;
/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 */
//我的时间复杂度是On2，耗时太长，同时也不是出题者想要的答案。
public class Question84_own {
	public int largestRectangleArea(int[] heights) {
		int len = 0, result = 0;
		for (int i = 0; i < heights.length; i++) {
			if (i == 0 || heights[i] != heights[i - 1]) {
				for (int j = i; j < heights.length; j++) {
					len = j - i + 1;
					if (heights[j] < heights[i]) {
						
						len--;
						break;
					}
				}
				result = Math.max(result, len * heights[i]);
			}
		}
		return result;
	}
//	public int largestRectangleArea(int[] height) {
//        int len = height.length;
//        Stack<Integer> s = new Stack<Integer>();
//        int maxArea = 0;
//        for(int i = 0; i <= len; i++){
//            int h = (i == len ? 0 : height[i]);
//            if(s.isEmpty() || h >= height[s.peek()]){
//                s.push(i);
//            }else{
//                int tp = s.pop();
//                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
//                i--;
//            }
//        }
//        return maxArea;
//    }
}

package question.question1_99;
//用分治做，又快又好理解，简直是太适合这个题了
public class Question84_others1 {
	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		return getMax(heights, 0, heights.length);
	}

	int getMax(int[] heights, int s, int n) {
        if (s + 1 == n) return heights[s];
        if (s + 1 > n) return 0;
        boolean sort = true;
        int min = s, max = 0;
        for (int i = s+1; i < n; i++) {
            if (heights[i] < heights[i - 1]) sort = false;
            if (heights[i] < heights[min]) min = i;
        }
        if (sort) {
            for(int i = s; i < n; i++) max = Math.max(max,heights[i] * (n - i));
        }
        else max = Math.max(Math.max(getMax(heights,s,min),getMax(heights,min + 1,n)),heights[min] * (n - s));
        return max;
    }
}

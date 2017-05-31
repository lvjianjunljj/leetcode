package question.question300_399;

/*
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
 * Example 1:
 nums1 = [3, 4, 6, 5]
 nums2 = [9, 1, 2, 5, 8, 3]
 k = 5
 return [9, 8, 6, 5, 3]
 */
//我的方法思路是没有什么问题，但是耗时上长了一点——超时了。
public class Question321_own1 {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        aux(res, nums1, nums2, k, 0, 0, 0);
        return res;
    }
    
    protected static void aux(int[] res, int[] nums1, int[] nums2, int k, int i, int j, int index) {
        if (index >= k)
            return;
        int element1 = -1, element2 = -1, iTemp = -1, jTemp = -1;
        int firstEnd = Math.min(nums1.length,0- j + nums1.length + nums2.length - k + index + 1);
        int secondEnd = Math.min(nums2.length,0- i + nums1.length + nums2.length - k + index + 1);
        for (int m = i; m < firstEnd; m++) {
            if (element1 < nums1[m]) {
                element1 = nums1[m];
                iTemp = m;
            }
        }
        for (int m = j; m < secondEnd; m++) {
            if (element2 < nums2[m]) {
                element2 = nums2[m];
                jTemp = m;
            }
        }
        int element = Math.max(element1, element2);
        res[index++] = element;
        if (element1 > element2) {
            i = iTemp + 1;
        } else if (element1 < element2) {
            j = jTemp + 1;
        } else {
            aux(res, nums1, nums2, k, iTemp + 1, j, index);
            int[] com = new int[k - index];
            for (int m = 0; m < k - index; m++)
                com[m] = res[m + index];
            aux(res, nums1, nums2, k, i, jTemp + 1, index);
            if (greater(com, 0, res, index))
                i = iTemp + 1;
            else 
                j = jTemp + 1;
        }
        aux(res, nums1, nums2, k, i, j, index);
    }
    
    protected static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}

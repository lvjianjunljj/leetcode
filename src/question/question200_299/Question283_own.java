package question.question200_299;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
//将0放到数组的最后，two point很简单
public class Question283_own {
	public void moveZeroes(int[] nums) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				if (i != j) {
					nums[i] = nums[j];
					nums[j] = 0;
				}
				i++;
			}
		}
	}
	//这种two point的想法也不错
	public void moveZeroes2(int[] nums) {
        int index=0;
            for (int i=0;i<nums.length;i++){
                if (nums[i]!=0) nums[index++]=nums[i];
            }
            while(index<nums.length){
                nums[index++]=0;
            }
    }
}

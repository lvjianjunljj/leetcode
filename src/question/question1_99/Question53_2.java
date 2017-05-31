package question.question1_99;

public class Question53_2 {
	//用动态规划，维护一维数组，通过（贪心算法）
	public static void main(String[] args) {
		int[] nums = { 3, 6, -8, 7, 8, 9, -11, 9, 4, 3, 6, -8, 7, 8, 9, -11, 9,
				4, 3, 6, -8, 7, 8, 9, -11, 9, 4, 3, 6, -8, 7, 8, 9, -11, 9, 4,
				3, 6, -8, 7, 8, 9, -11, 9, 4, 3, 6, -8, 7, 8, 9, -11, 9, 4, 3,
				6, -8, 7, 8, 9, -11, 9, 4, 3, 6, -8, 7, 8, 9, -11, 9, 4 };
		System.out.println(maxSubArray(nums));
	}

	 public static int maxSubArray(int[] nums) {
	        int n = nums.length;
	        int[] sums = new int[n];
	        sums[0] = nums[0];
	        int result = sums[0];
	        for(int i = 1;i<n;i++){
	            if(sums[i-1]>0){
	                sums[i] = sums[i-1]+nums[i];
	            }else{
	                sums[i]=nums[i];
	            }
	            if(result<sums[i]){
	                result = sums[i];
	            }
	        }
	        return result;
	    }
}

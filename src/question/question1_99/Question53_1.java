package question.question1_99;

public class Question53_1 {
	//用动态规划，维护二维数组，报 Time Limit Exceeded错误
	public static void main(String[] args) {
		int[] nums = {3,6,-8,7,8,9,-11,9,4,3,6,-8,7,8,9,-11,9,4,3,6,-8,7,8,9,-11,9,4,3,6,-8,7,8,9,-11,9,4,3,6,-8,7,8,9,-11,9,4,3,6,-8,7,8,9,-11,9,4,3,6,-8,7,8,9,-11,9,4,3,6,-8,7,8,9,-11,9,4};
		System.out.println(maxSubArray(nums));
	}
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[][] sums = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0 ;j<n;j++){
                sums[i][j]=Integer.MIN_VALUE;
            }
        }
        return maxSubArrayAux(sums,nums,1,n);
    }
    protected static int maxSubArrayAux(int[][] sums,int[] nums,int i ,int j){
            if(i>j){
                return Integer.MIN_VALUE;
            }
            if(i==j){
                return nums[i-1];
            }
            if(sums[i-1][j-1] != Integer.MIN_VALUE){
                return sums[i-1][j-1];
            }
            int k = (i+j)/2;
            int behind =maxSubArrayAux(sums,nums,i,k-1);
            int front = maxSubArrayAux(sums,nums,k+1,j);
            int cross = nums[k-1];
            int cross_sum = nums[k-1];
            for(int p = k-2;p>i-2;p--){
                cross_sum += nums[p];
                if(cross_sum>cross){
                    cross = cross_sum;
                }
            }
            cross_sum = cross;
            for(int p =k;p<j;p++){
                cross_sum += nums[p];
                if(cross_sum>cross){
                    cross = cross_sum;
                }
            }
            if(behind>=front){
                sums[i-1][j-1] = behind;
            }else{
                sums[i-1][j-1] = front;
            }
            if(cross>sums[i-1][j-1]){
                sums[i-1][j-1] = cross;
            }
           
            return sums[i-1][j-1];
        }
}

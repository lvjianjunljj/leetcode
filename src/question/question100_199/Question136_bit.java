package question.question100_199;
/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Question136_bit {
	//用位运算的方法做
	public int singleNumber(int[] nums) {
	       int result = 0;
	       for(int i : nums){
	           result = result^i;
	       }
	       return result;
	    }
}

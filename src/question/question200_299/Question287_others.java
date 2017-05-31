package question.question200_299;

/*
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
//映射找环法，思路在https://segmentfault.com/a/1190000003817671#articleHeader19（下面也有），如果忘记了可以上去看看
public class Question287_others {
	// 题目给的测试案例也不需要考虑nums = null的情况
	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
/*
 * 假设数组中没有重复，那我们可以做到这么一点，就是将数组的下标和1到n每一个数一对一的映射起来。 比如数组是213,则映射关系为0->2, 1->1,
 * 2->3。假设这个一对一映射关系是一个函数f(n)，其中n是下标，f(n)是映射到的数。
 * 如果我们从下标为0出发，根据这个函数计算出一个值，以这个值为新的下标，再用这个函数计算，以此类推，直到下标超界。
 * 实际上可以产生一个类似链表一样的序列。比如在这个例子中有两个下标的序列，0->2->3。
 * 但如果有重复的话，这中间就会产生多对一的映射，比如数组2131,则映射关系为0->2, {1，3}->1, 2->3。
 * 这样，我们推演的序列就一定会有环路了，这里下标的序列是0->2->3->1->1->1->1->...，而环的起点就是重复的数。
 * 所以该题实际上就是找环路起点的题，和Linked List Cycle II一样。
 * 我们先用快慢两个下标都从0开始，快下标每轮映射两次，慢下标每轮映射一次，直到两个下标再次相同。
 * 这时候保持慢下标位置不变，再用一个新的下标从0开始，这两个下标都继续每轮映射一次，当这两个下标相遇时，就是环的起点，也就是重复的数。
 */

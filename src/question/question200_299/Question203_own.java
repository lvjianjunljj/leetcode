package question.question200_299;

/*
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
//理好思路很简单——有可能剔除头节点，所以要新建一个节点
public class Question203_own {
	public ListNode removeElements(ListNode head, int val) {
		ListNode prev = new ListNode(0);
		prev.next = head;
		ListNode cur = prev, next = prev.next;
		while (next != null) {
			if (next.val == val)
				cur.next = next.next;
			else
				cur = next;
			next = next.next;
		}
		return prev.next;
	}
}

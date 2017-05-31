package question.question1_99;

import help.ListNode;

//精简了一下也就这样了，只不过是把两遍一样的while写成了一个，看看答案有什么更好的方法吗
public class Question92_own2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode prev = null, cur = head;
		int k = 1;
		while (k < m) {
			prev = cur;
			cur = cur.next;
			k++;
		}
		ListNode pre = null, curr = cur;
		while (k <= n) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
			k++;
		}
		if (m == 1) {
			head.next = curr;
			return pre;
		}
		cur.next = curr;
		prev.next = pre;
		return head;
	}
}

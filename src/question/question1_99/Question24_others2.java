package question.question1_99;

import help.ListNode;

//一遍遍历也是能做的，思考好cur下一个点定义在哪比较合适。
public class Question24_others2 {
	public ListNode swapPairs(ListNode head) {
		ListNode init = new ListNode(0);
		init.next = head;
		ListNode cur = init;
		while (cur.next != null && cur.next.next != null) {
			ListNode first = cur.next;
			ListNode second = first.next;
			ListNode next = second.next;
			cur.next = second;
			second.next = first;
			first.next = next;
			cur = first;
		}
		return init.next;
	}
}

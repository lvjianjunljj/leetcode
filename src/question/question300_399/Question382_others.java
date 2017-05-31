package question.question300_399;

import java.util.Random;
import help.ListNode;

//应用数学方法实现这种等概率——简直是牛逼。。。服，根本不需要多余的空间存储（while循环我给满分）
public class Question382_others {
	ListNode head;

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	public Question382_others(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		Random ra = new Random();
		ListNode res = new ListNode(0);
		ListNode cur = head;
		int i = 1;
		while (cur != null) {
			if (ra.nextInt(i++) == 0)
				res = cur;
			cur = cur.next;
		}
		return res.val;
	}
}

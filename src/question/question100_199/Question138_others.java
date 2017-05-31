package question.question100_199;

import help.RandomListNode;
//既然不能用HashMap存数据，那完全可以将复制的数据存到链表对应点的后面——反正链表的拆分与合并很简单
//注：这道题要求本身的链表不能发生变化——所以最后定义的时候不能直接把需要的复制出来就完了，要对本身链表也维护好
public class Question138_others {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode oriCur = head;
		while (oriCur != null) {
			RandomListNode next = oriCur.next;
			RandomListNode copyCur = new RandomListNode(oriCur.label);
			oriCur.next = copyCur;
			copyCur.next = next;
			oriCur = next;
		}
		oriCur = head;
		while (oriCur != null) {
			if (oriCur.random != null)
				oriCur.next.random = oriCur.random.next;
			oriCur = oriCur.next.next;
		}
		RandomListNode cur = head;
		RandomListNode res = head.next;
		while (cur.next != null) {
			RandomListNode next = cur.next;
			cur.next = cur.next.next;
			cur = next;
		}
		return res;
	}
}

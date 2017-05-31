package question.question1_99;

import help.ListNode;

//多个已排序数组（或者链表）地merge完全可以用分治嘛，两两组合完了以后再两两组合，其实很简单
public class Question23_others2 {
	public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }
    
    private ListNode partion(ListNode[] lists, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return lists[i];
        }
        int mid = (i + j) / 2;
        ListNode node1 = partion(lists, i, mid);
        ListNode node2 = partion(lists, mid + 1, j);
        return merge(node1, node2);
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val > node2.val) {
            node2.next = merge(node1, node2.next);
            return node2;
        } else {
            node1.next = merge(node1.next, node2);
            return node1;
        }
    }
}

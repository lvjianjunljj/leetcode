package question.question100_199;

import help.TreeLinkNode;

//这个方法也算是巧妙啊，充分利用了之前定义好了的next属性。
public class Question116_others {
	public void connect(TreeLinkNode root) {
		TreeLinkNode prev = root;
		while (prev != null && prev.left != null) {
			TreeLinkNode cur = prev;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			prev = prev.left;
		}
	}
}

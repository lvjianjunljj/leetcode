package question.question100_199;

/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *  What if the given tree could be any binary tree? Would your previous solution still work?
 Note:
 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
import help.TreeLinkNode;
//根据116巧妙地利用已经定义好的next属性很快地解决了这道题
public class Question117_own {
	public void connect(TreeLinkNode root) {
		TreeLinkNode prev = root;
		while (prev != null) {
			TreeLinkNode cur = prev;
			TreeLinkNode underCur = null;
			prev = null;
			while (cur != null) {
				if (!(cur.left == null && cur.right == null)) {
					if (prev == null)
						prev = cur.left != null ? cur.left : cur.right;
					if (underCur == null) {
						if (cur.left != null && cur.right != null) {
							cur.left.next = cur.right;
							underCur = cur.right;
						} else
							underCur = cur.left != null ? cur.left : cur.right;
					} else {
						if (cur.left != null && cur.right != null) {
							underCur.next = cur.left;
							cur.left.next = cur.right;
							underCur = cur.right;
						} else {
							underCur.next = cur.left != null ? cur.left
									: cur.right;
							underCur = underCur.next;
						}
					}
				}
				cur = cur.next;
			}
		}
	}
}

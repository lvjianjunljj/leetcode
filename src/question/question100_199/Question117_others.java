package question.question100_199;

import help.TreeLinkNode;

//这种做法就是通过维护level和max才使得耗时大大降低，其实剔除这两个值这道题也完全是能做出来的，但是耗时会很高。
//维护level和max就是为了使得connect(node.left, level + 1);和connect(node.right, level + 1);两步不会重复运算
public class Question117_others {
	int max = -1;

	public void connect(TreeLinkNode root) {
		aux(root, 0);
	}

	private void aux(TreeLinkNode node, int level) {
		if (node == null)
			return;
		if (level > max) {
			TreeLinkNode n = node;
			while (n != null) {
				if (n.left != null)
					n.left.next = n.right != null ? n.right : findNext(n.next);
				if (n.right != null)
					n.right.next = findNext(n.next);
				n = n.next;
			}
			max = level;
		}
		aux(node.left, level + 1);
		aux(node.right, level + 1);
	}

	private TreeLinkNode findNext(TreeLinkNode node) {
		if (node == null)
			return null;
		if (node.left != null)
			return node.left;
		if (node.right != null)
			return node.right;
		return findNext(node.next);
	}
}

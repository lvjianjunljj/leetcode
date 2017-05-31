package algorithm;

import help.TreeNode;
import java.util.List;

/*
 * 如何实现二叉树的前中后序遍历，有两个要求：
 * 1. O(1)空间复杂度，即只能使用常数空间；
 * 2. 二叉树的形状不能被破坏（中间过程允许改变其形状）。
 * 通常，实现二叉树的前序（preorder）、中序（inorder）、后序（postorder）遍历有两个常用的方法：
 * 一是递归(recursive)，二是使用栈实现的迭代版本(stack+iterative)。
 * 这两种方法都是O(n)的空间复杂度（递归本身占用stack空间或者用户自定义的stack），所以不满足要求。
 * Morris Traversal方法可以做到这两点，与前两种方法的不同在于该方法只需要O(1)空间，而且同样可以在O(n)时间内完成。
 */
public class MorrisTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode l = new TreeNode(1);
		TreeNode r = new TreeNode(5);
		l.left = new TreeNode(0);
		l.right = new TreeNode(2);
		r.left = new TreeNode(4);
		TreeNode a = new TreeNode(6);
		r.right = a;
		root.left = l;
		root.right = r;
		morris_preOrder(root);
		morris_inOrder(root);
		morris_postOrder(root);
	}

	// 中序遍历
	/*
	 * 1.如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
	 * 2.如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 * a)如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
	 * b)如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）输出当前节点 当前节点更新， 为当前节点的右孩子
	 * 3.重复以上1、2直到当前节点为空。
	 */
	private static void morris_inOrder(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				System.out.println(cur.val);
				cur = cur.right;
			} else {
				TreeNode prev = cur.left;
				while (prev.right != null && prev.right != cur)
					prev = prev.right;
				if (prev.right == null) {
					prev.right = cur;
					cur = cur.left;
				} else {
					System.out.println(cur.val);
					cur = cur.right;
					prev.right = null;
				}
			}
		}
	}

	// 前序遍历（只是改变一下输出顺序就可以）
	/*
	 * 1.果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
	 * 2.如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 * a)如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。输出当前节点（在这里输出，这是与中序遍历唯一一点不同）。
	 * 当前节点更新为当前节点的左孩子。 b)如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。当前节点更新为当前节点的右孩子。
	 * 3.重复以上1、2直到当前节点为空。
	 */
	private static void morris_preOrder(TreeNode root) {
		TreeNode cur = root, prev = null;
		while (cur != null) {
			if (cur.left == null) {
				System.out.println(cur.val);
				cur = cur.right;
			} else {
				prev = cur.left;
				while (prev.right != null && prev.right != cur)
					prev = prev.right;
				if (prev.right == null) {
					System.out.println(cur.val);
					prev.right = cur;
					cur = cur.left;
				} else {
					cur = cur.right;
					prev.right = null;
				}
			}
		}
	}

	// 后序遍历——后续遍历稍显复杂，需要建立一个临时节点dump，令其左孩子是root。
	// 并且还需要一个子过程，就是倒序输出某两个节点之间路径上的各个节点。
	/*
	 * 当前节点设置为临时节点dump。 1.如果当前节点的左孩子为空，则将其右孩子作为当前节点。
	 * 2.如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 * a)如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
	 * b)如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空
	 * 倒序输出从当前节点的左孩子到该前驱节点这条路径上的所有节点。当前节点更新为当前节点的右孩子 3.重复以上1、2直到当前节点为空。
	 */
	private static void morris_postOrder(TreeNode root) {
		TreeNode tmp = new TreeNode(0);
		tmp.left = root;
		TreeNode cur = tmp;
		while (cur != null) {
			if (cur.left == null)
				cur = cur.right;
			else {
				TreeNode prev = cur.left;
				while (prev.right != null && prev.right != cur)
					prev = prev.right;
				if (prev.right == null) {
					prev.right = cur;
					cur = cur.left;
				} else {
					printReverse(cur.left, prev);
					cur = cur.right;
					prev.right = null;
				}
			}
		}
	}

	private static void reverse(TreeNode from, TreeNode to) {
		if (from == to)
			return;
		TreeNode prev = from, cur = from.right;
		while (prev != to) {
			TreeNode tmp = cur.right;
			cur.right = prev;
			prev = cur;
			cur = tmp;
		}
	}

	private static void printReverse(TreeNode from, TreeNode to) {
		reverse(from, to);
		TreeNode cur = to;
		while (cur != from) {
			System.out.println(cur.val);
			cur = cur.right;
		}
		System.out.println(from.val);
		reverse(to, from);
		// 两次reverse方法后其实是造成了一个循环的，但是在后序遍历中的prev.right = null;将这个循环恢复了
	}
}

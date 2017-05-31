package algorithm;

/*
 * 二叉树的遍历——非递归实现
 * 94/144/145给我出了一些方法，这里我根据网上的思路重新整理了一下，和之前写的题目思路略有不同，没事的时候看着玩玩
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import help.TreeNode;

public class NonRecursionTraversal {
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
		// preOrder(root);
		// inOrder(root);
		// postOrder1(root);
		// postOrder2(root);
		// levelOrder(root);
	}

	// 前序遍历（在将node进行push操作的时候就将其输出）
	private static void preOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				System.out.println(root.val);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop().right;
		}
	}

	// 前序遍历（在将node进行pop操作的时候就将其输出）
	private static void inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			System.out.println(root.val);
			root = root.right;
		}
	}

	// 后序遍历（和145的想法不一样了——因为是直接输出，不能用List的add(index, val)方法了）
	/*
	 * 方法1： 对于节点p可以分情况讨论 1. p如果是叶子节点，直接输出 2. p如果有孩子，且孩子没有被访问过，则按照右孩子，左孩子的顺序依次入栈
	 * 3. p如果有孩子，而且孩子都已经访问过，则访问p节点 如何来表示出p的孩是否都已经访问过了呢
	 * 最暴力的方法就是对每个节点的状态进行保存，这么做显然是可以的，但是空间复杂度太大了。 我们可以保存最后一个访问的节点last，如果满足
	 * (p->right==NULL && last ==p->left) || last=p->right，
	 * 那么显然p的孩子都访问过了，接下来可以访问p
	 */
	private static void postOrder1(TreeNode root) {
		if (root == null)
			return;
		TreeNode last = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode tmp = stack.peek();
			if ((tmp.left == null && tmp.right == null)
					|| (tmp.right == null && last == tmp.left)
					|| last == tmp.right) {
				System.out.println(tmp.val);
				last = tmp;
				stack.pop();
			} else {
				if (tmp.right != null)
					stack.push(tmp.right);
				if (tmp.left != null)
					stack.push(tmp.left);
			}

		}
	}

	/*
	 * 方法2： 其实我们希望栈中保存的从顶部依次是root->left, root->right, root，当符合上面提到的条件时，
	 * 就进行出栈操作。有一种巧妙的方法可以做到
	 * 对于每个节点，都压入两遍，在循环体中，每次弹出一个节点赋给p，如果p仍然等于栈的头结点，说明p的孩子们还没有被操作过，
	 * 应该把它的孩子们加入栈中，否则，访问p。也就是说，第一次弹出，将p的孩子压入栈中，第二次弹出，访问p。
	 */
	private static void postOrder2(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if (!stack.isEmpty() && tmp == stack.peek()) {
				if (tmp.right != null) {
					stack.push(tmp.right);
					stack.push(tmp.right);
				}
				if (tmp.left != null) {
					stack.push(tmp.left);
					stack.push(tmp.left);
				}
			} else
				System.out.println(tmp.val);
		}
	}

	// 层序遍历（用Queue特别好实现）
	private static void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			System.out.println(tmp.val);
			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
		}
	}
}

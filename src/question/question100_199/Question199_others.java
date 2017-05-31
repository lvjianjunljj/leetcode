package question.question100_199;

import help.TreeNode;

import java.util.ArrayList;
import java.util.List;
//这种想法才是耗时最低的，既然是要找最右端的数存下来，就直接先运行node.right然后再left同时存入之后就不需要再进行修改了，因为一定是最右端的
public class Question199_others {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		aux(res, root, 0);
		return res;
	}

	private void aux(List<Integer> res, TreeNode node, int level) {
		if (node == null)
			return;
		if (level >= res.size())
			res.add(node.val);
		aux(res, node.right, level + 1);
		aux(res, node.left, level + 1);
	}
}

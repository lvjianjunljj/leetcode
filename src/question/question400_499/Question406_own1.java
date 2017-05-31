package question.question400_499;

/*
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers 
 * (h, k), where h is the height of the person and k is the number of people in front of this person who 
 * have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * Note:
 * The number of people is less than 1,100.
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//维护一个数据结构，包含high和order，根据high排序以后再根据order向数组中插入，想法能解决这道题但是不是特别精炼
//因为已经排好序了所以插入的时候就容易了
public class Question406_own1 {

	class Node implements Comparable {
		int high;
		int order;

		public Node(int high, int order) {
			this.high = high;
			this.order = order;
		}

		@Override
		public int compareTo(Object o) {
			if (high > ((Node) o).high)
				return 1;
			else if (high < ((Node) o).high)
				return -1;
			else {
				if (order > ((Node) o).order)
					return 1;
				else if (order < ((Node) o).order)
					return -1;
				else
					return 0;
			}
		}
	}

	public int[][] reconstructQueue(int[][] people) {
		int n = people.length;
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < n; i++)
			list.add(new Node(people[i][0], people[i][1]));
		Collections.sort(list);
		int[][] res = new int[n][2];
		for (int i = 0; i < n; i++)
			res[i][0] = -1;
		for (int i = 0; i < n; i++) {
			int order = list.get(i).order, start = 0;
			while (res[start][0] != -1 && res[start][0] != list.get(i).high)
				start++;
			while (order > 0) {
				if (res[start][0] == list.get(i).high || res[start][0] == -1)
					order--;
				start++;
			}
			while (res[start][0] != -1)
				start++;
			res[start][0] = list.get(i).high;
			res[start][1] = list.get(i).order;
		}
		return res;
	}
}

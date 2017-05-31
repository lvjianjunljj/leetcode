package question.question300_399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//他人给的方法，思路前置是巧妙，不是简简单单地使用dfs——就是从最长的一条或几条路上截得到中间点
//同时Collections.singletonList(0)和HashSet.iterator().next()掌握一下
public class Question310_others1 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        ArrayList<HashSet<Integer>> adj = new ArrayList<HashSet<Integer>>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<Integer>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);
    
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                //用HashSet<>的好处是remove的时候传入的int就是remove的值而不是index
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}

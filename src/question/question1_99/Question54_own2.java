package question.question1_99;

import java.util.ArrayList;
import java.util.List;

//其实用for循环就好了
public class Question54_own2 {
	public List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0, i = 0, j = 0;
        int m = matrix.length;
        List<Integer> res = new ArrayList<Integer>();
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int k = 0; k < m * n; k++) {
            System.out.println(i + " " + j);
            res.add(matrix[i][j]);
            visit[i][j] = true;
            if (dir == 0) {
                if (j == n - 1 || visit[i][j + 1]) {
                    i++;
                    dir = 1;
                } else {
                    j++;
                }
            } else if (dir == 1) {
                if (i == m - 1 || visit[i + 1][j]) {
                    j--;
                    dir = 2;
                } else {
                    i++;
                }
            } else if (dir == 2) {
                if (j == 0 || visit[i][j - 1]) {
                    i--;
                    dir = 3;
                } else {
                    j--;
                }
            } else {
                if (i == 0 || visit[i - 1][j]) {
                    j++;
                    dir = 0;
                } else {
                    i--;
                }
            }
        }
        return res;
    }
}

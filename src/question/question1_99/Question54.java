package question.question1_99;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class Question54 {
	public List<Integer> spiralOrder(int[][] matrix) {
        int n = 0;
        int m = matrix.length;
        if(m>0){
            n = matrix[0].length;
        }
        String turn = "right";
        List<Integer> result = new ArrayList<Integer>();
        if(m==0||n==0){
            return result;
        }
        int[][] mark = new int[m+2][n+2];
        int i=1,j=1;
        for(int k=0;k<n+2;k++){
            mark[0][k]=1;
            mark[m+1][k]=1;
        }
        for(int k=0;k<m+2;k++){
            mark[k][0]=1;
            mark[k][n+1]=1;
        }
        
        while(mark[i-1][j]==0||mark[i+1][j]==0||mark[i][j-1]==0||mark[i][j+1]==0){
            result.add(matrix[i-1][j-1]);
            mark[i][j]=1;
            if(turn=="right"){
                if(mark[i][j+1]==0){
                    j++;
                }else{
                    turn="down";
                    i++;
                }
            }else if(turn=="down"){
                if(mark[i+1][j]==0){
                    i++;
                }else{
                    turn="left";
                    j--;
                }
            }else if(turn=="left"){
                if(mark[i][j-1]==0){
                    j--;
                }else{
                    turn="up";
                    i--;
                }
            }else if(turn=="up"){
                if(mark[i-1][j]==0){
                    i--;
                }else{
                    turn="right";
                    j++;
                }
            }
            
        }
        result.add(matrix[i-1][j-1]);
        return result;
    }
}

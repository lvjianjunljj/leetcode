package question.question1_99;
/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
import java.util.Stack;
//我已经尽力了，可是我好像并写不出来（网上给的答案维护了一个坐标j，而且他只向stack中存放每个“(”的坐标）
public class Question32_others {
	public int longestValidParentheses(String s) {
	    Stack<Integer> stack = new Stack<Integer>();
	    int max=0;
	    int left = -1;
	    for(int j=0;j<s.length();j++){
	        if(s.charAt(j)=='(') stack.push(j);            
	        else {
	            if (stack.isEmpty()) left=j;
	            else{
	            	//将stack中的元素直接pop出是为了能使得j减去坐标的前一个值才能得到想要的长度
	                stack.pop();
	                if(stack.isEmpty()) max=Math.max(max,j-left);
	                else max=Math.max(max,j-stack.peek());
	               }
	            }
	        }
	    return max;
	}
}

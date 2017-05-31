package question.question1_99;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */

//没什么意思，简单
public class Question09_own {
	public boolean isPalindrome(int x) {
        long tmp = 0;
        int y = x;
        while (y > 0) {
            tmp = tmp * 10 + (y % 10);
            y /= 10;
        }
        return tmp == x;
    }
}

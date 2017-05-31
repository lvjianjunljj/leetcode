package question.question1_99;

//不用把整个树转置过来，只要转置后半段就行了
public class Question09_others {
	public boolean isPalindrome(int x) {
        if (x < 10 && x >= 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        int tmp = 0;
        while (tmp < x) {
            tmp = tmp * 10 + (x % 10);
            if (tmp == 0) {
                return false;
            }
            x /= 10;
        }
        return tmp == x || (x == tmp / 10);
    }
}

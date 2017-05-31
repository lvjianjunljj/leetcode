package question.question500_599;

import java.util.*;

/**
 * @author lvjj
 * @date 2017年4月16日Given a positive 32-bit integer n, you need to find the
 *       smallest 32-bit integer which has exactly the same digits existing in
 *       the integer n and is greater in value than n. If no such positive
 *       32-bit integer exists, you need to return -1.
 * 
 *       Example 1: Input: 12 Output: 21 Example 2: Input: 21 Output: -1
 */
public class Question556_others {
	// 这一道题和之前的两道题就没什么联系了，感觉和一道做过的string的题一样，没意思
	public int nextGreaterElement(int n) {
        String s = "" + n;
        char[] str = s.toCharArray();
        boolean have = false;
        for (int i = str.length - 1; i > 0; i--) {
            if (str[i] > str[i - 1]) {
                have = true;
                int index = i;
                while (index < str.length && str[index] > str[i - 1]) {
                    index++;
                }
                index--;
                char tmp = str[i - 1];
                str[i - 1] = str[index];
                str[index] = tmp;
                Arrays.sort(str, i, str.length);
                break;
            }
        }
        try {
            if (have) {
                return Integer.parseInt(new String(str));
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}

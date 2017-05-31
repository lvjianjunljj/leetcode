package question.question400_499;

import java.util.ArrayList;
import java.util.List;

//这才是最好的方法，通过维护一个参数count省略了每次的循环判断（注意count++操作的时机）
public class Question438_others {
	public List<Integer> findAnagrams(String s, String p) {
        int[] list = new int[26];
        int count = p.length();
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < p.length(); i++) {
            list[p.charAt(i) - 'a']++;
        }
        int right = 0, left = 0;
        while (right < s.length()) {
            if (list[s.charAt(right++) - 'a']-- > 0) {
                count--;
            }
            if (count == 0) {
                res.add(left);
            }
            if (right - left == p.length()) {
                if (list[s.charAt(left++) - 'a']++ >= 0) {
                    count++;
                }
            }
        }
        return res;
    }
}

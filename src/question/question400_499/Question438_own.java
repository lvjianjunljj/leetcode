package question.question400_499;
/*
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
import java.util.ArrayList;
import java.util.List;

//这已经是我能想到最快的方法了，每一次遍历只要改变两个值再进行常数次遍历就能判断就完成了
public class Question438_own {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] list = new int[26];
        int[] compare = new int[26];
        for (int i = 0; i < p.length(); i++) {
            list[s.charAt(i) - 'a']++;
            compare[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (i == 0) {
                if (judge(list, compare)) {
                    res.add(i);
                }
            } else {
                list[s.charAt(i - 1) - 'a']--;
                list[s.charAt(i + p.length() - 1) - 'a']++;
                if (judge(list, compare)) {
                    res.add(i);
                }
            }
        }
        return res;
    }
    
    private boolean judge(int[] list, int[] compare) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != compare[i]) {
                return false;
            }
        }
        return true;
    }
}

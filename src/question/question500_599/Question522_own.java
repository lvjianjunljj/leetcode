package question.question500_599;

import java.util.*;

import help.TreeNode;

/**
 * @author lvjj
 * @date 2017年4月16日Given a list of strings, you need to find the longest
 *       uncommon subsequence among them. The longest uncommon subsequence is
 *       defined as the longest subsequence of one of these strings and this
 *       subsequence should not be any subsequence of the other strings.
 * 
 *       A subsequence is a sequence that can be derived from one sequence by
 *       deleting some characters without changing the order of the remaining
 *       elements. Trivially, any string is a subsequence of itself and an empty
 *       string is a subsequence of any string.
 * 
 *       The input will be a list of strings, and the output needs to be the
 *       length of the longest uncommon subsequence. If the longest uncommon
 *       subsequence doesn't exist, return -1.
 * 
 *       Example 1: Input: "aba", "cdc", "eae" Output: 3 Note:
 * 
 *       All the given strings' lengths will not exceed 10. The length of the
 *       given list will be in the range of [2, 50].
 */
public class Question522_own {
	//这种做法简直是无聊 之后再看看还有别的做法吗
	public int findLUSlength(String[] strs) {
        if (strs.length < 1) {
            return -1;
        }
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else if (o1.length() > o2.length()) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        };
        Set<String> set = new HashSet<String>();
        Arrays.sort(strs, c);
        for (int i = 1; i < strs.length; i++) {
            if (i == 1 && !strs[1].equals(strs[0])) {
                return strs[0].length();
            }
            if (strs[i].length() == strs[0].length()) {
                set.add(strs[i]);
                if (!strs[i].equals(strs[i - 1]) && (i == strs.length - 1 || !strs[i].equals(strs[i + 1]))) {
                    return strs[0].length();
                }
            } else {
                if (!strs[i].equals(strs[i - 1]) && (i == strs.length - 1 || !strs[i].equals(strs[i + 1]))) {
                    boolean re = true;
                    for (String s : set) {
                        if (contain(s, strs[i])) {
                            re = false;
                            break;
                        }
                    }
                    if (re) {
                        return strs[i].length();
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean contain(String longStr, String shortStr) {
        int i = 0, j = 0;
        while (i < longStr.length() && j < shortStr.length()) {
            if (longStr.charAt(i++) == shortStr.charAt(j)) {
                j++;
            }
        }
        return j == shortStr.length();
    }
}

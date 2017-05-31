package question.question400_499;

import java.util.HashSet;

//从高位向低位走，高位能是1就尽量使其为1
public class Question421_others1 {
	public int findMaximumXOR(int[] nums) {
        int res = 0, flag = 0;
        for (int i = 30; i>= 0; i--) {
            HashSet<Integer> set = new HashSet<Integer>();
            flag = flag | (1 << i);
            for (int k : nums) {
                set.add(k & flag);
            }
            int tmp = res | (1 << i);
            for (int k : set) {
                if (set.contains(tmp ^ k)) {
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }
}

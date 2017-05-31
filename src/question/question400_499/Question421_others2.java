package question.question400_499;

//用TrieNode做也是可以的，但是写起来也是蛮麻烦的
public class Question421_others2 {
	public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int i : nums) {
            buildTrie(root, i);
        }
        int res = 0;
        for (int i : nums) {
            int tmp = findMax(root, i);
            if (tmp > res) {
                res = tmp;
            }
        }
        return res;
    }
    
    private int findMax(TrieNode root, int num) {
        int max = 0;
        for (int i = 30; i >= 0; i--) {
            int flag = (num & (1 << i)) > 0 ? 1 : 0;
            if (root.next[1 - flag] != null) {
                max += (1 << i);
                root = root.next[1 - flag];
            } else {
                root = root.next[flag];
            }
        }
        return max;
    }
    
    private void buildTrie(TrieNode root, int num) {
        for (int i = 30; i >= 0; i--) {
            int flag = (num & (1 << i)) > 0 ? 1 : 0;
            if (root.next[flag] == null) {
                root.next[flag] = new TrieNode();
            }
            root = root.next[flag];
        }
    }
    
    class TrieNode {
        TrieNode[] next;
        
        public TrieNode() {
            next = new TrieNode[2];
        }
        
    }
}

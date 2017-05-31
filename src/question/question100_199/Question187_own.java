package question.question100_199;

/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//用HashMap存值，可以使得出现多次的只被加到List中一次，耗时不是很高
public class Question187_own {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		int len = s.length();
		for (int i = 0; i < len - 9; i++) {
			String str = s.substring(i, i + 10);
			if (!map.containsKey(str))
				map.put(str, true);
			else {
				if (map.get(str))
					res.add(str);
				map.put(str, false);
			}
		}
		return res;
	}
}

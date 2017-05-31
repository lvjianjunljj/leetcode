package question.question1_99;

/*
 * Given an array of words and a length L, format the text such that each line has exactly L characters 
 * and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 */
import java.util.ArrayList;
import java.util.List;

//就是根据题意做做做就行了，就是找到对应的每行的符合要求的String然后加一个结尾判断就结束了——没什么好的算法
public class Question68_own {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
		int index = 0;
		while (true) {
			int end = index;
			int len = words[end++].length();
			while (end < words.length
					&& len + words[end].length() + 1 <= maxWidth) {
				len += words[end++].length() + 1;
			}
			if (end < words.length) {
				int count = end - index;
				int space = maxWidth - len;
				if (count == 1) {
					String last = "";
					for (int k = 0; k < space; k++)
						last += " ";
					res.add(words[index] + last);
				} else {
					int every = space / (count - 1) + 1;
					int more = space % (count - 1);
					String tmp = words[index];
					for (int k = 0; k < count - 1; k++) {
						for (int j = 0; j < every; j++)
							tmp += " ";
						if (k < more)
							tmp += " ";
						tmp += words[index + 1 + k];
					}
					res.add(tmp);
				}
				index = end;
			} else {
				String tmp = words[index];
				for (int i = index + 1; i < end; i++) {
					tmp += " " + words[i];
				}
				while (tmp.length() < maxWidth)
					tmp += " ";
				res.add(tmp);
				break;
			}
		}
		return res;
	}
}

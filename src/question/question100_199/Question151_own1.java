package question.question100_199;

/*
 * Given an input string, reverse the string word by word.
 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 */
//很简单，没什么好说的
public class Question151_own1 {
	public String reverseWords(String s) {
		String[] array = s.split(" ");
		String res = "";
		if (s.equals("") || s == null)
			return res;
		for (String i : array) {
			i.trim();
			if (!i.equals(""))
				res = i + " " + res;
		}
		return res.trim();
	}
}

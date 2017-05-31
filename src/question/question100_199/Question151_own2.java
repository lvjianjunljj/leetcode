package question.question100_199;
//当频繁调用两个String相加时，用StringBuilder的append实现远好于String的相加
public class Question151_own2 {
	public String reverseWords(String s) {
		String[] array = s.split(" ");
		StringBuilder res = new StringBuilder();
		if (s.equals("") || s == null)
			return res.toString();
		for (int i = array.length - 1; i > -1; i--) {
			array[i].trim();
			if (!array[i].equals(""))
				res.append(array[i] + " ");
		}
		return res.toString().trim();
	}
}

package question.question1_99;
/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 */
//用toCharArray()方法应该要比split()方法快（toCharArray()方法耗时0ms）
public class Question58_own {
	public int lengthOfLastWord(String s) {
		int res = 0;
		char[] array = s.trim().toCharArray();
		for (int i = array.length - 1; i > -1; i--) {
			if (array[i] != ' ')
				res++;
			else
				return res;
		}
		return res;
	}
	//split()方法耗时3ms
//	public int lengthOfLastWord(String s) {
//        String[] array = s.trim().split(" ");
//        if (array.length < 1)
//            return 0;
//        else
//            return array[array.length - 1].length();
//    }
}

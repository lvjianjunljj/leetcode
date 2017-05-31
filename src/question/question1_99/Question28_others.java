package question.question1_99;

//精简一下代码，但是算法本身其实是很麻烦的，就这样吧，就是一道easy而已
public class Question28_others {
	public int strStr(String haystack, String needle) {
		for (int i = 0;; i++)
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j >= haystack.length())
					return -1;
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
	}
}

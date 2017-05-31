package question.question300_399;
//经过这种优化使耗时最低的方法，另外封装的isVowel的耗时远比用HashSet的contains方法低的多
//同时，直接把最后的将char[]转成String这种方式耗时低很多。要注意了。
public class Question345_others {
	public String reverseVowels(String s) {
		char[] array = s.toCharArray();
		int i = 0, j = array.length - 1;
		while (i < j) {
			if (!isVowel(array[i]))
				i++;
			else if (!isVowel(array[j]))
				j--;
			else {
				char temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		return new String(array);
	}

	private boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
				|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}
}

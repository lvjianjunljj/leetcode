package question.question300_399;

import java.util.HashSet;
//看过了tag以后用了two point方法去做然而耗时还是很高，看来还是没有get到那个点
public class Question345_own2 {
	public String reverseVowels(String s) {
        HashSet<Character> dict = new HashSet<Character>();
        dict.add('a');
        dict.add('e');
        dict.add('i');
        dict.add('o');
        dict.add('u');
        dict.add('A');
        dict.add('E');
        dict.add('I');
        dict.add('O');
        dict.add('U');
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (!dict.contains(array[i]))
                i++;
            else if (!dict.contains(array[j]))
                j--;
            else {
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char k : array)
            sb.append(k);
		return sb.toString();
		//直接把最后的将char[]转成String用这种方式耗时低很多
		//return new String(array);
	}
}

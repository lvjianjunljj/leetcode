package question.question200_299;
//大于length的值就可以看作是length，所以是优先范围的排序，所以可以用类型计数排序的方法进行求解——这样也省略了排序的过程
//但是无法避免计数排序的劣势——空间复杂度是On
public class Question274_others2 {
	public int hIndex(int[] citations) {
        int length = citations.length;
        if (length == 0)
            return 0;
        int[] array = new int[length + 1];
        for (int i : citations) {
            if (i >= length)
                array[length]++;
            else
                array[i]++;
        }
        int t = 0;
        for (int i = length; i >= 0; i--) {
            t += array[i];
            if (t >= i)
                return i;
        }
        return 0;
    }
}

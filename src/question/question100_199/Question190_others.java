package question.question100_199;
//对于结果的维护最好也是用位运算进行，这样才规整且不用进行数据类型转换。
public class Question190_others {
	public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            if (i < 31)
                res <<= 1;
            n >>>= 1;
        }
        return res;
    }
}

package question.question1_99;

import java.util.ArrayList;
import java.util.List;

//这就是二进制到格雷码的编码规则，记住吧 f[i] = i ^ (i >> 1)——妙啊
/*
 * 二进制码 ----> 格雷码(编码)：
 * 从最右边一位起，依次将每一位与左边一位异或(XOR)，作为对应格雷码该位的值，最左边一位不变(相当于左边是0)。
 * G(i) = B(i+1) XOR B(i) ; 0 <= i < N - 1
 * G(i) = B(i)            ;      i = N - 1
 * 格雷码转换到自然二进制数
 * 设有 N 位格雷码 G(i)，把它转换成自然二进制数的算法如下。
 * 自然二进制码的最高位等于雷码的最高位；
 * 自然二进制码的次高位为最高位自然二进制码与次高位格雷码相异或；
 * 自然二进制码的其余各位与次高位自然二进制码的求法相类似。
 * B(i) = G(i)             ;      i = N - 1
 * B(i) = B(i+1) XOR G(i)  ; 0 <= i < N - 1
 */
public class Question89_others {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < (1 << n); i++)
			res.add(i ^ (i >> 1));
		return res;
	}
}

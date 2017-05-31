package question.question100_199;
//我也是只遍历了一遍，但是为什么我的时间这么长呢，草，真奇怪
//单论时间复杂多是一样的，但是我调用的remove方法所需要的时间更多，仅此而已
public class Question150_others {
	public static void main(String[] args) {
		String[] tokens = {"1","2","+"};
		System.out.println(evalRPN(tokens));
	}
	public static  int evalRPN(String[] tokens) {
		int[] ls = new int[tokens.length / 2 + 1];
		int index = 0;
		for (String token : tokens) {
			/*
			 * jdk 1.7 开始，switch语句支持 String 类型参数 ， 
			 * 此外还支持 int, char, byte （及其包装类Integer，Byte，Character）以及 enum 类型。 
			 * jdk 1.6 的switch不支持String类型，只支持后面几种。所以在jdk 1.6及以下版本，你可以定义一个enum类来存储你的String。
			 * 我就呵呵了
			 * 个人经验总结jdk1.8和myeclipse8.5不兼容
			 */
//			switch (token) {
//			case "+":
//				ls[index - 2] = ls[index - 2] + ls[index - 1];
//				index--;
//				break;
//			case "-":
//				ls[index - 2] = ls[index - 2] - ls[index - 1];
//				index--;
//				break;
//			case "*":
//				ls[index - 2] = ls[index - 2] * ls[index - 1];
//				index--;
//				break;
//			case "/":
//				ls[index - 2] = ls[index - 2] / ls[index - 1];
//				index--;
//				break;
//			default:
//				ls[index++] = Integer.parseInt(token);
//				break;
//			}
		}
		return ls[0];
	}
}

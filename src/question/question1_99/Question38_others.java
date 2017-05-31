package question.question1_99;
//思路和我一开始的想法是一样的，只是变了写法，不用封装一个方法降低了耗时。
public class Question38_others {
	public String countAndSay(int n) {
		StringBuilder curr = new StringBuilder("1");
		StringBuilder prev;
		int count;
		char say;
		for (int i = 1; i < n; i++) {
			prev = curr;
			curr = new StringBuilder();
			count = 1;
			say = prev.charAt(0);

			for (int j = 1, len = prev.length(); j < len; j++) {
				if (prev.charAt(j) != say) {
					curr.append(count).append(say);
					count = 1;
					say = prev.charAt(j);
				} else
					count++;
			}
			curr.append(count).append(say);
		}
		return curr.toString();

	}
}

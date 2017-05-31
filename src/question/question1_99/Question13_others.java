package question.question1_99;

//其实罗马数字减的情况就那么几种，很简单，别想得太复杂，根本不用分治
public class Question13_others {
	public int romanToInt(String s) {
		int sum = 0;
		if (s.indexOf("CD") != -1) {
			sum -= 200;
		}
		if (s.indexOf("CM") != -1) {
			sum -= 200;
		}
		if (s.indexOf("XL") != -1) {
			sum -= 20;
		}
		if (s.indexOf("XC") != -1) {
			sum -= 20;
		}
		if (s.indexOf("IV") != -1) {
			sum -= 2;
		}
		if (s.indexOf("IX") != -1) {
			sum -= 2;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'I') {
				sum++;
			} else if (c == 'V') {
				sum += 5;
			} else if (c == 'X') {
				sum += 10;
			} else if (c == 'L') {
				sum += 50;
			} else if (c == 'C') {
				sum += 100;
			} else if (c == 'D') {
				sum += 500;
			} else {
				sum += 1000;
			}
		}
		return sum;
	}
}

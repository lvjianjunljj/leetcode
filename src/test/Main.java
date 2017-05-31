package test;

import java.util.*;

public class Main {
	public String reverseStr(String s, int k) {
		char[] list = s.toCharArray();
		for (int i = 0; i < s.length() / k; i++) {
			reverse(list, i * k, i * k + k - 1);

		}
		reverse(list, s.length() / k * k, s.length() - 1);
		return new String(list);
	}

	private void reverse(char[] list, int i, int j) {
		for (int k = 0; k < (j - i + 1) / 2; k++) {
			char tmp = list[i + k];
			list[i + k] = list[j - k];
			list[j - k] = tmp;
		}
	}
}

package question.question1_99;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:
 string convert(string text, int nRows);
 */

//我对数据的存储的行列规则完全与示例给的一样
public class Question06_own {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		StringBuilder res = new StringBuilder();
		char[][] data = new char[numRows][s.length() * 2 / (numRows * 2 - 2)
				+ 1];
		aux(s, data, 0, 0, numRows, true);
		for (char[] list : data)
			for (char cha : list)
				if (cha != 0)
					res.append(cha);
		return res.toString();
	}

	private void aux(String s, char[][] data, int row, int index, int numRows,
			boolean high) {
		if (high) {
			for (int i = 0; i < numRows; i++) {
				if (i + index >= s.length())
					return;
				data[i][row] = s.charAt(i + index);
			}
		} else {
			for (int i = 0; i < numRows - 2; i++) {
				if (i + index >= s.length())
					return;
				data[numRows - 2 - i][row] = s.charAt(i + index);
			}
		}
		aux(s, data, row + 1, index + (high ? numRows : numRows - 2), numRows,
				!high);
	}
}

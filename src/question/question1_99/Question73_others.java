package question.question1_99;
//这方法简直是巧妙，通过两个boolean值rowFlag和columnFlag来判断首行和首列是否最后全为零，然后再将为零的行号和列号直接存在首行和首列中
public class Question73_others {
	public void setZeroes(int[][] matrix) {
		boolean rowFlag = false, columnFlag = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						rowFlag = true;
					if (j == 0)
						columnFlag = true;
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++)
			if (matrix[i][0] == 0)
				for (int j = 0; j < matrix[i].length; j++)
					matrix[i][j] = 0;
		for (int j = 1; j < matrix[0].length; j++)
			if (matrix[0][j] == 0)
				for (int i = 0; i < matrix.length; i++)
					matrix[i][j] = 0;
		if (rowFlag)
			for (int j = 0; j < matrix[0].length; j++)
				matrix[0][j] = 0;
		if (columnFlag)
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;
	}
}

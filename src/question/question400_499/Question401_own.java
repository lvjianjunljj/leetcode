package question.question400_499;

/*
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), 
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on, 
 * return all possible times the watch could represent.
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" 
 * is not valid, it should be "10:02".
 */
import java.util.ArrayList;
import java.util.List;

//标准的回溯——非常简单
public class Question401_own {
	public List<String> readBinaryWatch(int num) {
		int[] list = new int[10];
		List<String> res = new ArrayList<String>();
		dfs(res, list, 0, 0, num);
		return res;
	}

	private void dfs(List<String> res, int[] list, int count, int index, int num) {
		if (count == num) {
			int hour = 0, min = 0, i = 0;
			for (; i < 4; i++)
				hour = (hour << 1) + list[i];
			for (; i < 10; i++)
				min = (min << 1) + list[i];
			if (hour < 12 && min < 60)
				res.add(hour + ":" + (min < 10 ? "0" : "") + min);
			return;
		}
		for (int i = index; i < 10; i++) {
			list[i] = 1;
			dfs(res, list, count + 1, i + 1, num);
			list[i] = 0;
		}
	}
}

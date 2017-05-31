package question.question200_299;

/*
 * You are playing the following Bulls and Cows game with your friend: 
 * You write down a number and ask your friend to guess what the number is. 
 * Each time your friend makes a guess, you provide a hint that indicates 
 * how many digits in said guess match your secret number exactly in both digit and position 
 * (called "bulls") and how many digits match the secret number but locate in the wrong position 
 * (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * For example:
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, 
 * use A to indicate the bulls and B to indicate the cows. In the above example, 
 * your function should return "1A3B".
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, 
 * and your function should return "1A1B".
 */
import java.util.HashMap;
import java.util.HashSet;

//暂时的想法只能是用两个HashMAp来存储secret和guess的信息在进行比较，没有别的想法
public class Question299_own {
	public String getHint(String secret, String guess) {
		int a = 0;
		int b = 0;
		HashMap<Character, HashSet<Integer>> map1 = new HashMap<Character, HashSet<Integer>>();
		HashMap<Character, HashSet<Integer>> map2 = new HashMap<Character, HashSet<Integer>>();
		for (int i = 0; i < secret.length(); i++) {
			if (!map1.containsKey(secret.charAt(i)))
				map1.put(secret.charAt(i), new HashSet<Integer>());
			map1.get(secret.charAt(i)).add(i);
		}
		for (int i = 0; i < guess.length(); i++) {
			if (!map2.containsKey(guess.charAt(i)))
				map2.put(guess.charAt(i), new HashSet<Integer>());
			map2.get(guess.charAt(i)).add(i);
		}
		for (char i : map2.keySet()) {
			if (map1.containsKey(i)) {
				HashSet<Integer> set1 = map1.get(i);
				HashSet<Integer> set2 = map2.get(i);
				int sum = Math.min(set1.size(), set2.size());
				int aTemp = 0;
				for (int j : set2)
					if (set1.contains(j))
						aTemp++;
				a += aTemp;
				b += sum - aTemp;
			}
		}
		return a + "A" + b + "B";
	}
}

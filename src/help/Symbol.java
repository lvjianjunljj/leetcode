package help;

public class Symbol {
	public static long noSymbol(int n) {
		if (n < 0) {
			return (long) (Integer.MAX_VALUE) + Integer.MAX_VALUE + 2 + n;
		}
		return n;
	}
}

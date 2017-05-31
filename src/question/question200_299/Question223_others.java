package question.question200_299;

//这个方法也是非常好的
public class Question223_others {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int left = Math.max(A, E);
		int right = Math.max(left, Math.min(G, C));
		int bottom = Math.max(B, F);
		int top = Math.max(bottom, Math.min(D, H));
		return (C - A) * (D - B) + (G - E) * (H - F) - (right - left)
				* (top - bottom);
	}
}

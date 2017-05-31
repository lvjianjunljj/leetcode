package algorithm;

//用枚举类实现单例模式
public class Singleton2 {
	public static void main(String[] args) {
		Singleton s = Singleton.INSTANCE;
		Singleton s2 = Singleton.INSTANCE;
		System.out.println(s == s2);
	}
}


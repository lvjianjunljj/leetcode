package algorithm;

//用静态内部类实现单例模式
public class Singleton1 {

	static class SingleHolder {
		static Singleton1 single = new Singleton1();
	}

	public static Singleton1 getInstance() {
		return SingleHolder.single;
	}
}

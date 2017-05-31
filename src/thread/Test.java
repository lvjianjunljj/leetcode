package thread;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		Server server = new Server();
		ThreadA a = new ThreadA(server);
		ThreadB b = new ThreadB(server);
		a.start();
		b.start();
//		System.out.println(111);
	}
}

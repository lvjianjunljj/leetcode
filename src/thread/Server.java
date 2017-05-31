package thread;

public class Server {
	synchronized public void methodA() throws InterruptedException {
		System.out.println("methodA...1");
		System.out.println("methodA...2");
		System.out.println("methodA...3");
		System.out.println("methodA...4");
		System.out.println("methodA...5");
		ThreadC c= new ThreadC(new Join());
		c.start();
		c.join(1000);
		System.out.println("methodA...6");
		System.out.println("methodA...7");
		System.out.println("methodA...8");
		System.out.println("methodA...9");
		System.out.println("methodA...10");
	}
	
	synchronized public void methodB() {
		System.out.println("methodB...1");
		System.out.println("methodB...2");
		System.out.println("methodB...3");
		System.out.println("methodB...4");
		System.out.println("methodB...5");
		System.out.println("methodB...6");
		System.out.println("methodB...7");
		System.out.println("methodB...8");
		System.out.println("methodB...9");
		System.out.println("methodB...10");
	}
}

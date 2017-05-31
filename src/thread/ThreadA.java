package thread;

public class ThreadA extends Thread {
	private Server server;
	public ThreadA(Server server) {
		this.server = server;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			server.methodA();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package thread;

public class ThreadB extends Thread {
	private Server server;
	public ThreadB(Server server) {
		this.server = server;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		server.methodB();
	}
}

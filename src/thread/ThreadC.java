package thread;

public class ThreadC extends Thread {
	private Join join;

	public ThreadC(Join join) {
		this.join = join;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			join.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

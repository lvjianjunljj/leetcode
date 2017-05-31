package thread;

public class Join {
	public void join() throws InterruptedException {
		System.out.println("join...start");
		Thread.sleep(3000);
		System.out.println("join...end");
	}
}

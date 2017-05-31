package homework;

public class MaritalStatus {
	// 默认刚建立person的时候为单身
	String status = "single";

	public void marry() {
		try {
			if (status.equals("single") || status.equals("divorced")
					|| status.equals("widow")) {
				status = "married";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("已婚情况下不能结婚");
			e.printStackTrace();
		}
	}

	public void divorce() {
		try {
			if (status.equals("married")) {
				status = "divorced";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("只有已婚情况下可以离婚");
			e.printStackTrace();
		}
	}

	public void widow() {
		try {
			if (status.equals("married") || status.equals("divorced")) {
				status = "widow";
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("只有已婚或离婚情况下可以丧夫");
			e.printStackTrace();
		}
	}
}

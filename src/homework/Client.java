package homework;

public class Client {
	public static void main(String[] args) {
		Person a = new  Person("single");
		Person b = new  Person("married");
		Person c = new  Person("married");
		Person d = new  Person("divorced");
		Person e = new  Person("divorced");
		Person f = new  Person("widow");
		System.out.println("a的婚姻状况:" + a.maritalStatus.status);
		System.out.println("b的婚姻状况:" + b.maritalStatus.status);
		System.out.println("c的婚姻状况:" + c.maritalStatus.status);
		System.out.println("d的婚姻状况:" + d.maritalStatus.status);
		System.out.println("e的婚姻状况:" + e.maritalStatus.status);
		System.out.println("f的婚姻状况:" + f.maritalStatus.status);
		a.maritalStatus.marry();
		b.maritalStatus.divorce();
		c.maritalStatus.widow();
		d.maritalStatus.marry();
		e.maritalStatus.widow();
		f.maritalStatus.marry();
		//e can`t transfer into divorced.
		e.maritalStatus.divorce();
		System.out.println("After transferring");
		System.out.println("a的婚姻状况:" + a.maritalStatus.status);
		System.out.println("b的婚姻状况:" + b.maritalStatus.status);
		System.out.println("c的婚姻状况:" + c.maritalStatus.status);
		System.out.println("d的婚姻状况:" + d.maritalStatus.status);
		System.out.println("e的婚姻状况:" + e.maritalStatus.status);
		System.out.println("f的婚姻状况:" + f.maritalStatus.status);
		
	}
}

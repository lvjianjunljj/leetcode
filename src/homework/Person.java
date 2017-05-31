package homework;

public class Person {

	MaritalStatus maritalStatus;

	public Person() {
		maritalStatus = new MaritalStatus();
	}

	public Person(String status) {
		maritalStatus = new MaritalStatus();
		maritalStatus.status = status;
	}

}

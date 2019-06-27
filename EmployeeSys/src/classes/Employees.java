package classes;

public class Employees {
	private int ID;
	private String lastname;
	private String firstname;
	private String email;
	private String dob;
	private String phone;
	private String position;
	private double salary;
	private String password;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employees() {
		
	}
	
	public Employees(String firstname, String lastname, String email, String dob, String phone, String postion,
			double salary) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		position = postion;
		this.salary = salary;
	}
	
	



	@Override
	public String toString() {
		return "Employees [lastname=" + lastname + ", firstname=" + firstname + ", email=" + email
				+ ", dob=" + dob + ", phone=" + phone + ", position=" + position + ", salary=" + salary + "]";
	}

	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String postion) {
		position = postion;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

	
}

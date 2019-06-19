package employeeClass;

public class Employees {
	private int ID;
	private String lastname;
	private String firstname;
	private String email;
	private int salary;
	private String city;
	private int phone;
	public Employees(int iD, String lastname, String firstname, String email, int salary, String city, int phone) {
		super();
		ID = iD;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.salary = salary;
		this.city = city;
		this.phone = phone;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
}

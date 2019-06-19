package employeeClass;

public class Account {
	private String usrname;
	private String password;
	private String type;
	
	public Account(String usrname, String password, String type) {
		super();
		this.usrname = usrname;
		this.password = password;
		this.type = type;
	};
	public Account(String usrname, String password) {
		super();
		this.usrname = usrname; 
		this.password = password;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	};
	
	
	
	
}

package employeeClass;

public class Permission {
	private int id;
	private int eID;
	private String type;
	private String applyDate;
	private String leavingDate;
	private String reason;
	
	public Permission(int eID, String type, String applyDate, String leavingDate, String reason) {
		super();
		this.eID = eID;
		this.type = type;
		this.applyDate = applyDate;
		this.leavingDate = leavingDate;
		this.reason = reason;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(String leavingDate) {
		this.leavingDate = leavingDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}

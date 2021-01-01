package Entity;

public class Administrator {
	
	private String Admin_id;
	private String Admin_name;
	private String Admin_password;
	
	public Administrator(String admin_id, String admin_name, String admin_password) {
		super();
		Admin_id = admin_id;
		Admin_name = admin_name;
		Admin_password = admin_password;
	}
	public Administrator() {
		// TODO Auto-generated constructor stub
	}
	public String getAdmin_id() {
		return Admin_id;
	}
	public void setAdmin_id(String admin_id) {
		Admin_id = admin_id;
	}
	public String getAdmin_name() {
		return Admin_name;
	}
	public void setAdmin_name(String admin_name) {
		Admin_name = admin_name;
	}
	public String getAdmin_password() {
		return Admin_password;
	}
	public void setAdmin_password(String admin_password) {
		Admin_password = admin_password;
	}
}
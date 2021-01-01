package Entity;

public class Account {
	private String a_id;
	private String a_name;
	private float a_balance;
	
	public Account(String a_id, String a_name, float a_balance) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_balance = a_balance;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public float getA_balance() {
		return a_balance;
	}
	public void setA_balance(float a_balance) {
		this.a_balance = a_balance;
	}
}
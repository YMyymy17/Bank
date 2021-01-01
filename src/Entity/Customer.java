package Entity;

public class Customer {
	private String Customer_id;
	private String Customer_name;
	private String Customer_sex;
	private String Customer_tel;
	private String Customer_home;
	
	public Customer(String Customer_id, String Customer_name, String Customer_sex, String Customer_tel) {
		super();
		this.Customer_id = Customer_id;
		this.Customer_name = Customer_name;
		this.Customer_sex = Customer_sex;
		this.Customer_tel = Customer_tel;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(String customer_id) {
		Customer_id = customer_id;
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public String getCustomer_sex() {
		return Customer_sex;
	}
	public void setCustomer_sex(String customer_sex) {
		Customer_sex = customer_sex;
	}
	public String getCustomer_tel() {
		return Customer_tel;
	}
	public void setCustomer_tel(String customer_tel) {
		Customer_tel = customer_tel;
	}
	public String getCustomer_home() {
		return Customer_home;
	}
	public void setCustomer_home(String customer_home) {
		Customer_home = customer_home;
	}	
}
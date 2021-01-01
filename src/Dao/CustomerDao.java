package Dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DButil.DBUtil;
import Entity.Customer;

public class CustomerDao {
	public int addCustomer(Customer c) {
		String sql = "insert into Customer values(?,?,?,?,?)";
		return DBUtil.executeUpdateByParams(sql,c.getCustomer_id(),c.getCustomer_name(),c.getCustomer_sex(),c.getCustomer_tel(),c.getCustomer_home());
	}
	
	public List<Customer> allCustomer(){
		List<Customer> clist=new ArrayList<Customer>();
		String sql="select * from Customer";
		ResultSet rs=DBUtil.executeQuery(sql);
		try{
			while(rs.next()){
				Customer c=new Customer();
				c.setCustomer_id(rs.getString(1));
				c.setCustomer_name(rs.getString(2));
				c.setCustomer_sex(rs.getString(3));
				c.setCustomer_tel(rs.getString(4));
				c.setCustomer_home(rs.getString(5));
				clist.add(c);
			}
			DBUtil.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	
	public Customer queryCustomerById(String id) {
		Customer c = null;
		String sql = "select * from Customer where Customer_id='" + id + "'";
		ResultSet rs = DBUtil.executeQuery(sql);
		try {
			if (rs.next()) {
				c=new Customer();
				c.setCustomer_id(rs.getString(1));
				c.setCustomer_name(rs.getString(2));
				c.setCustomer_sex(rs.getString(3));
				c.setCustomer_tel(rs.getString(4));
				c.setCustomer_home(rs.getString(5));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return c;
	}
	
	public Customer queryCustomerByName(String name) {
		Customer c=null;
		String sql = "select * from Customer where Customer_name='" + name + "'";
		ResultSet rs = DBUtil.executeQuery(sql);
		try {
			if (rs.next()) {
				c=new Customer();
				c.setCustomer_id(rs.getString(1));
				c.setCustomer_name(rs.getString(2));
				c.setCustomer_sex(rs.getString(3));
				c.setCustomer_tel(rs.getString(4));
				c.setCustomer_home(rs.getString(5));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return c;
	}

	public int updateCustomer(Customer c) {
		String sql = "update Customer set Customer_name=?,Customer_sex=?,Customer_tel=?,Customer_home=? where Customer_id=?";
		return DBUtil.executeUpdateByParams(sql,c.getCustomer_name(),c.getCustomer_sex(),c.getCustomer_tel(),c.getCustomer_home(),c.getCustomer_id());
	}
}
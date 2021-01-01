package Dao;

import java.sql.ResultSet;

import DButil.DBUtil;
import Entity.Account;

public class AccountDao {
	public int addAccount(Account a) {
		String sql = "insert into Account values(?,?,?)";
		return DBUtil.executeUpdateByParams(sql,a.getA_id(),a.getA_name(),a.getA_balance());
	}
	
	public Account queryAccountById(String id) {
		Account a = null;
		String sql = "select * from Account where Account_id='" + id + "'";
		ResultSet rs = DBUtil.executeQuery(sql);
		try {
			if (rs.next()) {
				a=new Account();
				a.setA_id(rs.getString(1));
				a.setA_name(rs.getString(2));
				a.setA_balance(rs.getFloat(3));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return a;
	}
	
	public int updateAccount(Account a) {
		String sql = "update Account set account_balance=? where account_id=?";
		return DBUtil.executeUpdateByParams(sql,a.getA_balance(),a.getA_id());
	}
	
}

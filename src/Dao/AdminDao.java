package Dao;

import java.sql.ResultSet;

import DButil.DBUtil;
import Entity.Administrator;

public class AdminDao {
	public Administrator queryAccountById(String id) {
		Administrator a = null;
		String sql = "select * from Administrator where admin_id='" + id + "'";
		ResultSet rs = DBUtil.executeQuery(sql);
		try {
			if (rs.next()) {
				a=new Administrator();
				a.setAdmin_id(rs.getString(1));
				a.setAdmin_name(rs.getString(2));
				a.setAdmin_password(rs.getString(3));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return a;
	}
}
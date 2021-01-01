package Dao;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DButil.DBUtil;
import Entity.History;

public class HistoryDao {
	String strDateFormat = "yyyy-MM-dd HH:mm:ss";
	SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	
	public int addHistory(History h) {
		String sql = "INSERT INTO `history` (id,name,home,kind,date,rate,num) values (?,?,?,?,?,?,?)";
		return DBUtil.executeUpdateByParams(sql,h.getId(),h.getName(),h.getHome(),h.getKind(),h.getDate(),h.getRate(),h.getNum());
	}
	
	public List<History> allHistoryById(String id){
		List<History> clist=new ArrayList<History>();
		String sql="select * from history where id='" + id +"'";
		ResultSet rs=DBUtil.executeQuery(sql);
		try{
			while(rs.next()){
				History h=new History();
				h.setId(rs.getString(2));
				h.setName(rs.getString(3));
				h.setHome(rs.getString(4));
				h.setKind(rs.getString(5));
				h.setDate(rs.getString(6));
				h.setRate(rs.getFloat(7));
				h.setNum(rs.getFloat(8));
				clist.add(h);
			}
			DBUtil.closeConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return clist;
    }
	
	@SuppressWarnings("null")
	public History queryHistoryByName(String name) {
		History h=new History();
		String sql = "select * from History where name='" + name + "'";
		ResultSet rs = DBUtil.executeQuery(sql);
		try {
			if (rs.next()) {
				h.setId(rs.getString(2));
				h.setName(rs.getString(3));
				h.setHome(rs.getString(4));
				h.setKind(rs.getString(5));
				h.setDate(rs.getString(6));
				h.setRate(rs.getFloat(7));
				h.setNum(rs.getFloat(8));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return h;
	}
	
	public History queryHistoryByTime(String id) {
		History h=new History();
		String sql =" select * from history where id='" + id +"' ORDER BY date DESC LIMIT 1";
		ResultSet rs = DBUtil.executeQuery(sql);
		try {
			if (rs.next()) {
				h.setId(rs.getString(2));
				h.setName(rs.getString(3));
				h.setHome(rs.getString(4));
				h.setKind(rs.getString(5));
				h.setDate(rs.getString(6));
				h.setRate(rs.getFloat(7));
				h.setNum(rs.getFloat(8));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return h;
	}
	
}
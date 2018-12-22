package function;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.MySQLConnUtils;
import model.monhoc;

public class monhocf {


	public monhoc getmamon(String tenmon) {
		Connection connection = MySQLConnUtils.getMySQLConnection();
        try {
        	Statement state = connection.createStatement();
        	 String sql = "select * from monhoc where TenMon='" + tenmon + "'";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
            	monhoc mh = new monhoc();
                mh.setMamon(rs.getString("MaMon"));
                mh.setTenmon(rs.getString("TenMon"));
                return mh;
            }
        } catch (SQLException ex) {
        	 ex.getStackTrace();
        }
		return null;
	}


	public ArrayList<monhoc> getmonhoc() {
		Connection connection = MySQLConnUtils.getMySQLConnection();      
        try {
        	Statement state = connection.createStatement();
        	String sql = "select * from thitracnghiem.monhoc ";
            ResultSet rs = state.executeQuery(sql);
            ArrayList<monhoc> arr = new ArrayList<>(); 
            while (rs.next()) {
            	monhoc mh = new monhoc();
                mh.setMamon(rs.getString("MaMon"));
                mh.setTenmon(rs.getString("TenMon"));
                arr.add(mh);
            }
            return arr;
        } catch (SQLException ex) {
        	 ex.getStackTrace();
        }
		return null;
	}

}

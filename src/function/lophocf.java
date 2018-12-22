package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import connect.MySQLConnUtils;
import model.lophoc;

public class lophocf {
	public ArrayList<lophoc> getclass ()
	{
		Connection connection = MySQLConnUtils.getMySQLConnection();    
		try {
			Statement state = connection.createStatement();
        	String sql = "select * from thitracnghiem.lop ";
            ResultSet rs = state.executeQuery(sql);
            ArrayList<lophoc> lh = new ArrayList<>();
            while(rs.next())
            {
            	lophoc lophoc = new lophoc();
            	lophoc.setMalop(rs.getString("MaLop"));
            	lophoc.setTenlop(rs.getString("TenLop"));
            	lh.add(lophoc);
            }
            return lh;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public List<lophoc> getclassstd(String studentid)
	{
		Connection connection = MySQLConnUtils.getMySQLConnection();    
		try {
			String sql ="select lop.malop,tenlop from nguoidung,hoc,lop where nguoidung.manguoidung=hoc.manguoidung and lop.malop=hoc.malop and nguoidung.manguoidung=?";
			PreparedStatement  ps = connection.prepareStatement(sql);
			ps.setString(1, studentid);
			ResultSet rs = ps.executeQuery();
			List<lophoc> lh = new ArrayList<lophoc>();
			while(rs.next())
			{
				lophoc lophoc = new lophoc();
				lophoc.setMalop(rs.getString("malop"));
				lophoc.setTenlop(rs.getString("tenlop"));
				lh.add(lophoc);
			}
			return lh;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public  List<lophoc> getttlophoc()
	{
		Connection connection = MySQLConnUtils.getMySQLConnection();
		try {
			String sql="select lop.malop,lop.tenlop,count(manguoidung) as soluong from lop left join hoc on lop.malop = hoc.malop group by lop.malop,lop.tenlop";
			PreparedStatement  ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<lophoc> lh = new ArrayList<lophoc>();
			while(rs.next())
			{
				lophoc lophoc = new lophoc();
				lophoc.setMalop(rs.getString("malop"));
				lophoc.setTenlop(rs.getString("tenlop"));
				lophoc.setSoluong(rs.getInt("soluong"));
				lh.add(lophoc);
			}
			return lh;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int addclass(String malop,String tenlop)
	{
		Connection connnection = MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "INSERT INTO lop (MaLop,TenLop) VALUES (?,?)";
			PreparedStatement ps = connnection.prepareStatement(sql);
			ps.setString(1, malop);
			ps.setString(2, tenlop);
			int dem= ps.executeUpdate();
			return dem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
public int  deleteclass(String ID) {
		
		try {
			Connection connnection = MySQLConnUtils.getMySQLConnection();
			String sql = "delete from lop where MaLop=?";
			PreparedStatement  ps = connnection.prepareStatement(sql);
			ps.setString(1, ID);
			int dem = ps.executeUpdate();
			return  dem;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;		
	}
}

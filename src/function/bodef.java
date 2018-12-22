package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bode;
import model.pagehome;
import model.lophoc;
import model.nguoidung;
import connect.MySQLConnUtils;

public class bodef {
	public boolean TaoBoDe(bode bode) {
		Connection connnection = MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "INSERT INTO bode (MaBoDe, TenBoDe, SLKho, SLTBinh, SLDe, MaMon) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = connnection.prepareStatement(sql);
			ps.setString(1, bode.getMaBode());
			ps.setString(2, bode.getTenBoDe());
			ps.setInt(3, bode.getSlKho());
			ps.setInt(4, bode.getSlTB());
			ps.setInt(5, bode.getSlDe());
			ps.setString(6, bode.getMaMon());
			ps.execute();
			String sql2 = "INSERT INTO bode_lop (MaLop, MaBoDe, SoLanNopToiDa, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianLamBai) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps2 = connnection.prepareStatement(sql2);
			ps2.setString(1, bode.getMaLop());
			ps2.setString(2, bode.getMaBode());
			ps2.setInt(3, bode.getSoLanNopToiDa());
			ps2.setTimestamp(4, bode.getThoiGianBatDau());
			ps2.setTimestamp(5, bode.getThoiGianKetThuc());
			ps2.setTime(6, bode.getThoiGianLamBai());
			ps2.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<pagehome> loadhomepage (List<lophoc> classofstd)
	{
		Connection connnection = MySQLConnUtils.getMySQLConnection();
		List<pagehome> ph = new ArrayList<pagehome>();
		try {
			for (lophoc lophoc : classofstd) {
				String sql="select lop.malop,lop.tenlop,bode.mabode,bode.tenbode, thoigianbatdau,"
						+ "thoigianketthuc,thoigianlambai,solannoptoida, count(manguoidung) "
						+ "from lop inner join bode_lop on lop.malop = bode_lop.malop "
						+ "inner join bode on bode_lop.mabode=bode.mabode "
						+ "left join ketquathi on ketquathi.mabode = bode.mabode "
						+ "where lop.malop=?";
				PreparedStatement  ps = connnection.prepareStatement(sql);
				ps.setString(1, lophoc.getMalop());
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					pagehome pagehome = new pagehome();
					pagehome.setMalop(rs.getString("malop"));
					pagehome.setTenlop(rs.getString("tenlop"));
					pagehome.setMabode(rs.getString("mabode"));
					pagehome.setTenbode(rs.getString("tenbode"));
					pagehome.setThoigianbatdau(rs.getTimestamp("thoigianbatdau"));
					pagehome.setThoigianketthuc(rs.getTimestamp("thoigianketthuc"));
					pagehome.setThoigianlambai(rs.getTime("thoigianlambai"));
					pagehome.setSolanlambaitoida(rs.getInt("solannoptoida"));
					pagehome.setSolanlambai(rs.getInt("count(manguoidung)"));
					ph.add(pagehome);
				}
			}
			return ph;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public pagehome getdetails (String mabd)
	{
		Connection connnection = MySQLConnUtils.getMySQLConnection();
		try {
		String	sql="select lop.malop,lop.tenlop,bode.mabode,bode.tenbode,thoigianbatdau,thoigianketthuc,thoigianlambai from lop inner join bode_lop on lop.malop = bode_lop.malop inner join bode on bode_lop.mabode=bode.mabode where bode.mabode=?";
		PreparedStatement  ps = connnection.prepareStatement(sql);
		ps.setString(1, mabd);
		ResultSet rs = ps.executeQuery();
		pagehome ph = new pagehome();
		while(rs.next())
		{
			ph.setMalop(rs.getString("malop"));
			ph.setMabode(rs.getString("mabode"));
			ph.setTenlop(rs.getString("tenlop"));
			ph.setTenbode(rs.getString("tenbode"));
			ph.setThoigianbatdau(rs.getTimestamp("thoigianbatdau"));
			ph.setThoigianketthuc(rs.getTimestamp("thoigianketthuc"));
			ph.setThoigianlambai(rs.getTime("thoigianlambai"));
		}
		return ph;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void BoDe_CauHoi(String  maBode, int maCauhoi) {
		Connection connnection = MySQLConnUtils.getMySQLConnection();
		try {
			String sql = "INSERT INTO bode_cauhoi (MaBoDe, MaCauHoi) VALUES (?,?)";
			PreparedStatement ps = connnection.prepareStatement(sql);
			ps.setString(1, maBode);
			ps.setInt(2, maCauhoi);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<bode>  getbodekhongthuoclop (String classid)
	{
		Connection connnection = MySQLConnUtils.getMySQLConnection();
		try {
			String sql= "select * from (select Mabode,TenBoDe from bode) as t1 where t1.MaBoDe not in (select bode.Mabode from bode_lop inner join bode on bode_lop.MaBoDe=bode.MaBoDe where bode_lop.malop=?)";
			PreparedStatement ps = connnection.prepareStatement(sql);
			ps.setString(1, classid);
			ResultSet rs = ps.executeQuery();
			java.util.List<bode> lch = new ArrayList<bode>();
			while(rs.next())
			{
				bode bd = new bode();
				bd.setMaBode(rs.getString("Mabode"));
				bd.setTenBoDe(rs.getString("TenBoDe"));
				lch.add(bd);
			}
			return lch;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	public List<bode> getbodeclass(String classid)
	{
		Connection connnection = MySQLConnUtils.getMySQLConnection();
		try {
			String sql="select bode.mabode,tenbode,SoLanNopToiDa,thoigianbatdau,thoigianketthuc,thoigianlambai from bode inner join bode_lop on bode.mabode=bode_lop.mabode where bode_lop.malop=?";
			PreparedStatement  ps = connnection.prepareStatement(sql);
			ps.setString(1, classid);
			ResultSet rs = ps.executeQuery();
			java.util.List<bode> lch = new ArrayList<bode>();
			while(rs.next())
			{
				bode bd = new bode();
				bd.setMaBode(rs.getString("mabode"));
				bd.setTenBoDe(rs.getString("tenbode"));
				bd.setSoLanNopToiDa(rs.getInt("SoLanNopToiDa"));
				bd.setThoiGianBatDau(rs.getTimestamp("thoigianbatdau"));
				bd.setThoiGianKetThuc(rs.getTimestamp("thoigianketthuc"));
				bd.setThoiGianLamBai(rs.getTime("thoigianlambai"));
				lch.add(bd);
			}
			return lch;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public int addbodevaolop (bode bode)
	{
		Connection connnection = MySQLConnUtils.getMySQLConnection();
		try {
			String sql2 = "INSERT INTO bode_lop (MaLop, MaBoDe, SoLanNopToiDa, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianLamBai) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps2 = connnection.prepareStatement(sql2);
			ps2.setString(1, bode.getMaLop());
			ps2.setString(2, bode.getMaBode());
			ps2.setInt(3, bode.getSoLanNopToiDa());
			ps2.setTimestamp(4, bode.getThoiGianBatDau());
			ps2.setTimestamp(5, bode.getThoiGianKetThuc());
			ps2.setTime(6, bode.getThoiGianLamBai());
			int dem = ps2.executeUpdate();
			return dem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public int deletebodeclass (String classid,String bodeid)
	{
		Connection connnection = MySQLConnUtils.getMySQLConnection();
		try {
			String sql ="delete from bode_lop where malop=? and mabode=?";
			PreparedStatement ps = connnection.prepareStatement(sql);
			ps.setString(1, classid);
			ps.setString(2, bodeid);
			int dem= ps.executeUpdate();
			return dem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}

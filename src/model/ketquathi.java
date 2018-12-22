package model;

import java.sql.Timestamp;

public class ketquathi {
	private String manguoidung;
	private String mabode;
	private double diem;
	private Timestamp thoigiannopbai;
	private String tenlop;
	private String tenbode;
	private Timestamp thoigianbatdau;

	public Timestamp getThoigianbatdau() {
		return thoigianbatdau;
	}

	public void setThoigianbatdau(Timestamp thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}

	public String getManguoidung() {
		return manguoidung;
	}

	public void setManguoidung(String manguoidung) {
		this.manguoidung = manguoidung;
	}

	public String getMabode() {
		return mabode;
	}

	public void setMabode(String mabode) {
		this.mabode = mabode;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public Timestamp getThoigiannopbai() {
		return thoigiannopbai;
	}

	public void setThoigiannopbai(Timestamp thoigiannopbai) {
		this.thoigiannopbai = thoigiannopbai;
	}

	public String getTenlop() {
		return tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}

	public String getTenbode() {
		return tenbode;
	}

	public void setTenbode(String tenbode) {
		this.tenbode = tenbode;
	}

}

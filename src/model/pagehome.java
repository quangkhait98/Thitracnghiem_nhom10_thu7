package model;

import java.sql.Time;
import java.util.List;

public class pagehome {
	private String tenlop;
	private String malop;
	private int solanlambai;
	public int getSolanlambai() {
		return solanlambai;
	}

	public void setSolanlambai(int solanlambai) {
		this.solanlambai = solanlambai;
	}

	public int getSolanlambaitoida() {
		return solanlambaitoida;
	}

	public void setSolanlambaitoida(int solanlambaitoida) {
		this.solanlambaitoida = solanlambaitoida;
	}

	private String mabode;
	private String tenbode;
	private java.sql.Timestamp thoigianbatdau;
	private java.sql.Timestamp thoigianketthuc;
	private Time thoigianlambai;
	private int solanlambaitoida;

	public Time getThoigianlambai() {
		return thoigianlambai;
	}

	public void setThoigianlambai(Time thoigianlambai) {
		this.thoigianlambai = thoigianlambai;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getMabode() {
		return mabode;
	}

	public void setMabode(String mabode) {
		this.mabode = mabode;
	}

	public String getTenbode() {
		return tenbode;
	}

	public void setTenbode(String tenbode) {
		this.tenbode = tenbode;
	}

	public java.sql.Timestamp getThoigianbatdau() {
		return thoigianbatdau;
	}

	public void setThoigianbatdau(java.sql.Timestamp thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}

	public java.sql.Timestamp getThoigianketthuc() {
		return thoigianketthuc;
	}

	public void setThoigianketthuc(java.sql.Timestamp thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}

	public String getTenlop() {
		return tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}

}

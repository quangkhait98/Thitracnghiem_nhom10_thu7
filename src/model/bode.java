package model;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class bode {
	
	public bode(String maBode, String tenBoDe, int slDe, int slTB, int slKho, String maMon,
			int soLanNopToiDa, Timestamp thoiGianBatDau, Timestamp thoiGianKetThuc, Time thoiGianLamBai, String maLop) {
		this.maBode = maBode;
		this.tenBoDe = tenBoDe;
		this.slDe = slDe;
		this.slTB = slTB;
		this.slKho = slKho;
		this.maMon = maMon;
		this.soLanNopToiDa = soLanNopToiDa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.thoiGianLamBai = thoiGianLamBai;
		this.maLop = maLop;
	}
	
	public bode() {

	}

	public String getMaBode() {
		return maBode;
	}

	public void setMaBode(String maBode) {
		this.maBode = maBode;
	}

	public String getTenBoDe() {
		return tenBoDe;
	}

	public void setTenBoDe(String tenBoDe) {
		this.tenBoDe = tenBoDe;
	}

	public int getSlDe() {
		return slDe;
	}

	public void setSlDe(int slDe) {
		this.slDe = slDe;
	}

	public int getSlTB() {
		return slTB;
	}

	public void setSlTB(int slTB) {
		this.slTB = slTB;
	}

	public int getSlKho() {
		return slKho;
	}

	public void setSlKho(int slKho) {
		this.slKho = slKho;
	}


	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public int getSoLanNopToiDa() {
		return soLanNopToiDa;
	}

	public void setSoLanNopToiDa(int soLanNopToiDa) {
		this.soLanNopToiDa = soLanNopToiDa;
	}

	public Timestamp getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Timestamp thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Timestamp getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Timestamp thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public Time getThoiGianLamBai() {
		return thoiGianLamBai;
	}

	public void setThoiGianLamBai(Time thoiGianLamBai) {
		this.thoiGianLamBai = thoiGianLamBai;
	}
	
	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	private String maBode;
	private String tenBoDe;
	private int slDe;
	private int slTB;
	private int slKho;
	private String maMon;
	private int soLanNopToiDa;
	private Timestamp thoiGianBatDau;
	private Timestamp thoiGianKetThuc;
	private Time thoiGianLamBai;
	private String maLop;

}
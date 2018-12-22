package model;

public class cauhoi {
		
		private int macauhoi;
		private String noidung;
		private String loaicauhoi;
		private String dapan1;
		private String dapan2;
		private String dapan3;
		private String dapan4;
		private String mamon;
		private int dapandung;
		public int getDapandung() {
			return dapandung;
		}
		public void setDapandung(int dapandung) {
			this.dapandung = dapandung;
		}
		public cauhoi()
		{
			
		}
		public cauhoi(int macauhoi, String noidung, String loaicauhoi, String dapan1,String dapan2,String dapan3,String dapan4,String mamon,int dapandung)
		{
			this.macauhoi=macauhoi;
			this.noidung=noidung;
			this.loaicauhoi=loaicauhoi;
			this.dapan1=dapan1;
			this.dapan2=dapan2;
			this.dapan3=dapan3;
			this.dapan4=dapan4;
			this.mamon=mamon;
			this.dapandung=dapandung;
		}
		public int getMacauhoi() {
			return macauhoi;
		}
		public void setMacauhoi(int macauhoi) {
			this.macauhoi = macauhoi;
		}
		public String getNoidung() {
			return noidung;
		}
		public void setNoidung(String noidung) {
			this.noidung = noidung;
		}
		public String getLoaicauhoi() {
			return loaicauhoi;
		}
		public void setLoaicauhoi(String loaicauhoi) {
			this.loaicauhoi = loaicauhoi;
		}
		public String getDapan1() {
			return dapan1;
		}
		public void setDapan1(String dapan1) {
			this.dapan1 = dapan1;
		}
		public String getDapan2() {
			return dapan2;
		}
		public void setDapan2(String dapan2) {
			this.dapan2 = dapan2;
		}
		public String getDapan3() {
			return dapan3;
		}
		public void setDapan3(String dapan3) {
			this.dapan3 = dapan3;
		}
		public String getDapan4() {
			return dapan4;
		}
		public void setDapan4(String dapan4) {
			this.dapan4 = dapan4;
		}
		public String getMamon() {
			return mamon;
		}
		public void setMamon(String mamon) {
			this.mamon = mamon;
		}
}

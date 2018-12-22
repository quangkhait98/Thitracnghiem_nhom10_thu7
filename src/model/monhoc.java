package model;

public class monhoc {
		private String mamon;
		private String tenmon;
		public String getMamon() {
			return mamon;
		}
		public void setMamon(String mamon) {
			this.mamon = mamon;
		}
		public String getTenmon() {
			return tenmon;
		}
		public void setTenmon(String tenmon) {
			this.tenmon = tenmon;
		}
		
		public monhoc()
		{
		
		}
		public monhoc(String mamon,String tenmon)
		{
			this.mamon=mamon;
			this.tenmon=tenmon;
		}
}

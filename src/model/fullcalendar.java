package model;

public class fullcalendar {
	  public String id;
	    public String title;
	    public String start;
	    public String end;
	    public String tglambai;
	    public int solanlambaiconlai;
	    public int getSolanlambaiconlai() {
			return solanlambaiconlai;
		}
		public void setSolanlambaiconlai(int solanlambaiconlai) {
			this.solanlambaiconlai = solanlambaiconlai;
		}
		public String getTglambai() {
			return tglambai;
		}
		public void setTglambai(String tglambai) {
			this.tglambai = tglambai;
		}
		
	    public String getId() {
	        return id;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }
	    public String getTitle() {
	        return title;
	    }
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    public String getStart() {
	        return start;
	    }
	    public void setStart(String start) {
	        this.start = start;
	    }
	    public String getEnd() {
	        return end;
	    }
	    public void setEnd(String end) {
	        this.end = end;
	    }
}

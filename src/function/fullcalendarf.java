package function;

import java.util.ArrayList;
import java.util.List;

import model.fullcalendar;
import model.pagehome;

public class fullcalendarf {
	public ArrayList<fullcalendar> getcalendar(List<pagehome> pg) {
		if (pg != null) {
			ArrayList<fullcalendar> listcalendar = new ArrayList<fullcalendar>();
			for (pagehome pagehome : pg) {
				fullcalendar cld = new fullcalendar();
				if (pagehome.getMabode() != null) {
					cld.setId(pagehome.getMabode());
					cld.setTitle(pagehome.getTenlop() + " : " + pagehome.getTenbode());
					cld.setStart(pagehome.getThoigianbatdau().toString());
					cld.setEnd(pagehome.getThoigianketthuc().toString());
					cld.setTglambai(pagehome.getThoigianlambai().toString());
					cld.setSolanlambaiconlai((pagehome.getSolanlambaitoida() - pagehome.getSolanlambai()));
					listcalendar.add(cld);
				}
			}
			return listcalendar;
		}
		return null;
	}
}

package isi.ztm.ztmcontrat.serviceinterface;

import java.util.Date;

public interface IDateService {
	
public Date DateNow ();
	
	public Date ConvertStringToDate(String st);
	
	public Date ConvertLongToDate(long L);
	
	public long ConvertDateToLong(Date dt);

}

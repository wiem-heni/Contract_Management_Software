package isi.ztm.ztmcontrat.daointerface;

import java.util.Date;

public interface IDateDao {

	
	public Date DateNow ();
	
	public Date ConvertStringToDate(String st);
	
	public Date ConvertLongToDate(long L);
	
	public long ConvertDateToLong(Date dt);
	
	public Date ConvertStringToTime(String st);
}
